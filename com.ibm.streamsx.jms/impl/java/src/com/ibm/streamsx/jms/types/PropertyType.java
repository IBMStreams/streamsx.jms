/*******************************************************************************
 * Copyright (C) 2019, International Business Machines Corporation
 * All Rights Reserved
 *******************************************************************************/
package com.ibm.streamsx.jms.types;

import com.ibm.streams.operator.Type;

public enum PropertyType {

	BOOL, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, STRING, OBJECT;

	public static PropertyType getPropertyType(String typeSpecification) {

		String lcts = typeSpecification.toLowerCase();

		switch (lcts) {
			case "bool":
				return BOOL;
			case "byte":
				return BYTE;
			case "short":
				return SHORT;
			case "int":
				return INT;
			case "long":
				return LONG;
			case "float":
				return FLOAT;
			case "double":
				return DOUBLE;
			case "string":
				return STRING;
			case "object":
				return OBJECT;
			default:
				return null;
		}

	}

	public static boolean doTypeSpecAndAttributeTypeMatch(PropertyType typeSpecification, Type attributeType) {
		
		PropertyType mapsTo = null;
		
		switch(attributeType.getMetaType()) {
			case BOOLEAN:
				mapsTo = BOOL;
				break;
			case INT8:
				mapsTo = BYTE;
				break;
			case INT16:
				mapsTo = SHORT;
				break;
			case INT32:
				mapsTo = INT;
				break;
			case INT64:
				mapsTo = LONG;
				break;
			case FLOAT32:
				mapsTo = FLOAT;
				break;
			case FLOAT64:
				mapsTo = DOUBLE;
				break;
			case RSTRING:
				mapsTo = STRING;
				break;
			case BLOB:
				mapsTo = OBJECT;
				break;
			case BLIST:
			case BMAP:
			case BSET:
			case BSTRING:
			case COMPLEX32:
			case COMPLEX64:
			case DECIMAL128:
			case DECIMAL32:
			case DECIMAL64:
			case ENUM:
			case LIST:
			case MAP:
			case SET:
			case TIMESTAMP:
			case TUPLE:
			case UINT8:
			case UINT16:
			case UINT32:
			case UINT64:
			case USTRING:
			case XML:
			default:
				// Go with the default null
		}
		
		return (mapsTo == typeSpecification);
	}

}
