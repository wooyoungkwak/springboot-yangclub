package com.yang.springbootyangclub.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.springbootyangclub.libs.exceptions.YoungException;
import com.yang.springbootyangclub.libs.utils.JsonUtil;
import com.yang.springbootyangclub.model.entity.user.domain.User;
import com.yang.springbootyangclub.model.entity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * package name : com.yang.springbootyangclub.controller.login
 * Date : 2023-06-03
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
@RequiredArgsConstructor
@Controller
public class LoginPostController {

    private final UserService userService;

    private final ObjectMapper objectMapper;

    @PostMapping(value = "/login/login", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Object login(@RequestBody String body) throws YoungException {
        try {
            String result = "none";
            User user = objectMapper.readValue(body, User.class);
            if (userService.isUser(user.getId(), user.getPassword())) {
                result = "exist";
            }
            return result;
        } catch (JsonProcessingException e) {
            throw new YoungException(e);
        }
    }

    @PostMapping(value = "/login/register", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Object register(@RequestBody String body) throws YoungException {
        String result = "";

        try {
            System.out.println(" body =  " + body);
            JSONObject jsonObject = new JSONObject(body);
            System.out.println("jsonbody = " + jsonObject.toString());
            User user = null;
            user = JsonUtil.toObject(jsonObject, User.class);
//            userService.set(user);
            if (user != null) System.out.println(user.getId());
//            System.out.println( user.getPassword() );
//            System.out.println( user.getName() );

            result = "true";

        } catch (Exception e) {
            throw new YoungException(e);
        }

        return result;
    }

}
