/*******************************************************************************
 * Copyright (C) 2019, International Business Machines Corporation
 * All Rights Reserved
 *******************************************************************************/
package com.ibm.streamsx.jms;

/**
 * Descriptions for the JMS operators
 */
public class JMSOpDescriptions {

	public static final String JMS_HEADER_PROPERTIES_DESC = ""						//$NON-NLS-1$
            + "Specifies the mapping between JMS Header property values and"		//$NON-NLS-1$
            + "Streams tuple attributes. The format of the mapping is: \\n\\n"		//$NON-NLS-1$
            + "`propertyName1/streamsAttributeName1/typeSpecifier1,"				//$NON-NLS-1$
            + "propertyName2/streamsAttributeName2/typeSpecifier2,...` \\n\\n"		//$NON-NLS-1$
            + "Leading and trailing spaces are trimmed from property and\\n\\n"		//$NON-NLS-1$
            + "attribute names. The properties can be of the following types:\\n"	//$NON-NLS-1$
            + "\\n"																	//$NON-NLS-1$
            + "----------------------------------------------------------------\\n"	//$NON-NLS-1$
            + "| **Type specifier** | **Java / Property type** | **SPL / Attribute type** |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| bool           | boolean              | boolean              |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| byte           | byte                 | int8                 |\\n" //$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| short          | short                | int16                |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| int            | int                  | int32                |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| long           | long                 | int64                |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| float          | float                | float32              |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| double         | double               | float64              |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| string         | String               | rstring              |\\n"	//$NON-NLS-1$
            + "|--------------------------------------------------------------|\\n"	//$NON-NLS-1$
            + "| object         | Object               | Object               |\\n"	//$NON-NLS-1$		// TODO: Object type in SPL???
            + "----------------------------------------------------------------\\n"	//$NON-NLS-1$
            + "\\n"																	//$NON-NLS-1$
            + "If property or attribute type do not match the specified type, "		//$NON-NLS-1$
            + "an error is logged during operator initialization."					//$NON-NLS-1$
            + "\\n\\n";																//$NON-NLS-1$
	
}
