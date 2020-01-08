package com.revature.util;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*
 * Utility to reduce number of object mappers
 * 
 * write:	converts pojo to json, used to convert:
 * 			-game data sent to angular
 * 
 * read:	converts json to pojo, used to convert:
 * 			login credentials sent to java
 * 			liked/disliked game info sent to java
 */

public class JsonReader {

	public static final String CONTENT_TYPE = "application/json";
	
	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	private JsonReader() {
	}

	public static byte[] write(Object o) {
		try {
			return mapper.writeValueAsBytes(o);
		} catch (IOException e) {
			Logging.logJsonMarshalException(e, o.getClass());
		}
		return null;
	}

	public static Object read(InputStream is, Class<?> clazz) {
		try {
			return mapper.readValue(is, clazz);
		} catch (IOException e) {
			Logging.logJsonUnmarshalException(e, clazz);
		}
		return null;
	}

}
