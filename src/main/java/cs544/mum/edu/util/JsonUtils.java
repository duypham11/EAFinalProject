package cs544.mum.edu.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger logger = LogManager.getLogger(JsonUtils.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();
	static {
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	private JsonUtils(){
		
	}
	
	public static String getJsonFromObject(Object data) {
		try {
			return MAPPER.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			logger.info(e);
		}
		return null;
	}
	
	public static <T> T getObjectFromJson(String jsonData, Class<T> beanType) {
		try {
			return MAPPER.readValue(jsonData, beanType);
		} catch (Exception e) {
			logger.info(e);
			
		}
		return null;
	}
	
	public static <T> T getObjectFromJson(String jsonData, JavaType javaType)  {
		try {
			return MAPPER.readValue(jsonData, javaType);
		} catch (Exception e) {
			logger.info(e);
			
		}
		return null;
	}
	
	public static <T> T getObjectFromJson(String jsonData, TypeReference<T> typeReference) {
		try {
			return MAPPER.readValue(jsonData, typeReference);
		} catch (Exception e) {
			logger.info(e);
			
		}
		return null;
	}
}
