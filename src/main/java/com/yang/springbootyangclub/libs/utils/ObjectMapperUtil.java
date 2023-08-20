package com.yang.springbootyangclub.libs.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

    /**
     * object(class) -> json 구조의 문자열 (jsonStr)  변환
     *
     * @param objectMapper
     * @param object
     * @return  ( if failed , space character )
     */
    public static String objectToJsonStr(ObjectMapper objectMapper, Object object) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * json 구조의 문자열 (jsonStr) -> object(class) 구조 변환
     *
     * @param objectMapper
     * @param jsonStr
     * @param cls ( if failed , null )
     */
    public static <T>T jsonStrToObject(ObjectMapper objectMapper, String jsonStr, Class<T> cls) {
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return t;
        }
    }

    /**
     * object(class) -> JsonNode 로 변환
     *
     * @param objectMapper
     * @param object
     * @return (if failed , null )
     */
    public static JsonNode objectToJson(ObjectMapper objectMapper, Object object) {
        JsonNode jsonNode = null;
        try {
            String jsonStr  = objectToJsonStr(objectMapper, object);
            jsonNode = objectMapper.readTree(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return jsonNode;
        }
    }

}
