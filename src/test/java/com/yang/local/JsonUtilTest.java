package com.yang.local;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yang.springbootyangclub.libs.utils.JsonUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * package name : com.yang.local
 * Date : 2023-08-23
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
@RunWith(SpringRunner.class)
public class JsonUtilTest {

    @Test
    public void test_ToString(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonStr = JsonUtil.toString(new Sample("first", "wooyoung", LocalDateTime.now()));
        System.out.println("jsonStr = " + jsonStr);
    }

    @Test
    public void test_ToObject(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonStr = JsonUtil.toString(new Sample("first", "wooyoung", LocalDateTime.now()));
//        JsonUtil.toObject(objectMapper, jsonStr, Sample.class);
    }

}
