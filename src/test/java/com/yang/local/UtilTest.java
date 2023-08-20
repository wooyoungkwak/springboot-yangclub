package com.yang.local;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UtilTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test_jsonToString(){
        ResultData resultData = new ResultData("sss", "sample", "datas..");
        String resultString = classToString(objectMapper, resultData);
        System.out.println(resultString);
    }

    @Test
    public void test_jsonToObject() {
        String jonStr  = "{\"status\":\"sss\",\"message\":\"sample\",\"data\":\"datas..\"}" ;
        ResultData resultData =  jsonToObject(objectMapper, jonStr, ResultData.class);

        if ( resultData != null )
            System.out.println(resultData.getData() + " :: " +  resultData.getMessage() + " :: " + resultData.getStatus());
    }

    public String classToString(ObjectMapper objectMapper, Object object) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }


    public <T>T jsonToObject(ObjectMapper objectMapper, String jsonStr, Class<T> cls) {
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr, cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return t;
        }
    }
}
