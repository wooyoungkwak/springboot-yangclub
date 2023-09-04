package com.yang.springbootyangclub.libs.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Map;

public class JsonUtil {

    public enum JsonUtilModule {
        NONE,

        HIBERNATE
    }

    /**
     * object(class) -> json 구조의 문자열 (jsonStr)  변환
     *  ( Module None )
     * @param object
     * @return (if failed, space character)
     */
    public static String toString(Object object) {
        return toString(object, JsonUtilModule.NONE);
    }


    /**
     * object(class) -> json 구조의 문자열 (jsonStr)  변환
     *
     * @param object
     * @return (if failed, space character)
     */
    public static String toString(Object object, JsonUtilModule jsonUtilModule) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";

        switch (jsonUtilModule) {
            case HIBERNATE:
//                objectMapper.registerModule(new Hibernate5Module());
                break;
            case NONE:
            default:
        }

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
     * - 필수 : object 는 반드시 기본 생성자를 가지고 있어야함.
     * - 기본 생성자 : 파라미터가 없는 생성자
     *
     * @param jsonStr
     * @param cls          ( if failed , null )
     */
    public static <T> T toObject(String jsonStr, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            t = objectMapper.readValue(jsonStr, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return t;
        }
    }

    /**
     * jsonNode 구조 -> object(class) 구조 변환
     * - 필수 : object 는 반드시 기본 생성자를 가지고 있어야함.
     * - 기본 생성자 : 파라미터가 없는 생성자
     *
     * @param jsonNode
     * @param cls          ( if failed , null )
     */
    public static <T> T toObject(JsonNode jsonNode, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            t = objectMapper.treeToValue(jsonNode, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return t;
        }
    }

    /**
     * jsonObject 구조 -> object(class) 구조 변환
     * - 필수 : object 는 반드시 기본 생성자를 가지고 있어야함.
     * - 기본 생성자 : 파라미터가 없는 생성자
     *
     * @param jsonObject
     * @param cls          ( if failed , null )
     */
    public static <T> T toObject(JSONObject jsonObject, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            if (jsonObject == null || !(jsonObject instanceof JSONObject) ) {
                throw new Exception("JSONObject 가 없거나 JSONObject 타입이 아닙니다.");
            }

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            Map<String, Object> map = objectMapper.readValue(jsonObject.toString(), Map.class);
            t = objectMapper.convertValue(map, cls);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return t;
        }
    }

    /**
     * object(class) -> JsonNode 로 변환
     *
     * @param object
     * @return (if failed, null)
     */
    public static JsonNode toJsonNodes(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            String jsonStr = toString(object);
            jsonNode = objectMapper.readTree(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return jsonNode;
        }
    }

    /**
     *
     *
     *
     */
    public static JSONObject toJSONObject(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonObject = null;
        try {
            if (obj instanceof String) {
                jsonObject = new JSONObject((String) obj);
            } else {
                String jsonStr = toString(obj);
                jsonObject = new JSONObject(jsonStr);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return jsonObject;
        }
    }

    /**
     *
     *
     *
     */
    public static JsonNode toJsonNode(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            if (obj instanceof String) {
                jsonNode = objectMapper.readTree((String) obj);
            } else {
                String jsonStr = toString(obj);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return jsonNode;
        }
    }

}
