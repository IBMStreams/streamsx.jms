/*******************************************************************************
 * Copyright (C) 2019, International Business Machines Corporation
 * All Rights Reserved
 *******************************************************************************/
package com.ibm.streamsx.jms.helper;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.ibm.streams.operator.Attribute;
import com.ibm.streams.operator.OperatorContext;
import com.ibm.streams.operator.StreamSchema;
import com.ibm.streams.operator.Type;
import com.ibm.streams.operator.logging.LogLevel;
import com.ibm.streamsx.jms.JMSOpConstants;
import com.ibm.streamsx.jms.i18n.Messages;
import com.ibm.streamsx.jms.types.PropertyType;

public class JmsHeaderHelper {

	/**
	 * @param context
	 * @param streamSchema
	 * @param patTriplets
	 * @param logger
	 * @param tracer
	 */
	public static void prepareJmsHeaderPropertiesAccess(OperatorContext context,
														StreamSchema streamSchema,
														List<PropertyAttributeType> patTriplets,
														Logger logger,
														Logger tracer)
	{
    	List<String> jmsHeaderPropsToAccess = context.getParameterValues(JMSOpConstants.PARAM_JMS_HEADER_PROPS);

    	for(String configLine : jmsHeaderPropsToAccess) {
    		
    		String trimmedConfigLine = configLine.trim();
    		// Tokenize configuration string into property/attribute triplets around the commas
    		List<String> configTriplets = Arrays.asList(trimmedConfigLine.split(","));	//$NON-NLS-1$
    		
    		for(String triplet : configTriplets) {

        		String trimmedTriplet = triplet.trim();
        		// Tokenize triplet string into property/attribute triplets around the slashes
        		List<String> propAttrType = Arrays.asList(trimmedTriplet.split("/"));	//$NON-NLS-1$
        		
        		
        		if(propAttrType.size() != 3) {
        			String errMsg = Messages.getString("PARAMETER_ATTRIBUTE_TYPE_SPLIT_FAILED", new Object[] { propAttrType.toString() });	//$NON-NLS-1$
        			logger.log(LogLevel.ERROR, errMsg);
        			
        			// If we do not have three values the next checks
        			// will fail just because of that, so we continue
        			// right away
        			continue;
        		}
        		
    			boolean erroneousConfiguration = false;
    			
        		int attributeIdx = streamSchema.getAttributeIndex(propAttrType.get(1));
        		if(attributeIdx == -1) {
        			String errMsg = Messages.getString("PARAMETER_ATTRIBUTE_TYPE_UNKNOWN_ATTRIBUTE", new Object[] { propAttrType.get(1) });	//$NON-NLS-1$
        			logger.log(LogLevel.ERROR, errMsg);
        			erroneousConfiguration = true;
        		}
        		
        		PropertyType typeSpecification = PropertyType.getPropertyType(propAttrType.get(2));
        		if(typeSpecification == null) {
        			String errMsg = Messages.getString("PARAMETER_ATTRIBUTE_TYPE_UNKNOWN_TYPE", new Object[] { propAttrType.get(2) });	//$NON-NLS-1$
        			logger.log(LogLevel.ERROR, errMsg);
        			erroneousConfiguration = true;
        		}

        		if(attributeIdx != -1 && typeSpecification != null) {
            		Attribute	attribute	= streamSchema.getAttribute(attributeIdx);
            		Type 		attrType	= attribute.getType();

            		if(! PropertyType.doTypeSpecAndAttributeTypeMatch(typeSpecification, attrType)) {
            			String errMsg = Messages.getString("PARAMETER_ATTRIBUTE_TYPE_ATTRIBUTE_TYPE_NONMATCH", new Object[] { propAttrType.get(2), propAttrType.get(1), attrType.getLanguageType() });	//$NON-NLS-1$
            			logger.log(LogLevel.ERROR, errMsg);
            			erroneousConfiguration = true;
            		}
        		}
        		
        		// Do not use current configuration, if it is erroneous
        		if(erroneousConfiguration) continue;
        		
        		
        		PropertyAttributeType pat = new PropertyAttributeType(propAttrType.get(0), propAttrType.get(1), attributeIdx, typeSpecification);
        		patTriplets.add(pat);
    		}
    	}
	}
}
