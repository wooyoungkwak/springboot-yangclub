package com.yang.springbootyangclub.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.springbootyangclub.libs.exceptions.YoungException;
import com.yang.springbootyangclub.model.entity.user.domain.User;
import com.yang.springbootyangclub.model.entity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @PostMapping(value = "/login/login")
    public String login(@RequestBody String body) throws YoungException {
        try {
            String result = "none";
            User user =  objectMapper.readValue(body, User.class);
            if ( userService.isUser(user.getId(), user.getPassword()) ) {
              result = "exist";
            }
            return result;
        } catch (JsonProcessingException e) {
            throw new YoungException(e);
        }
    }

    @PostMapping(value = "/login/register")
    public String register(@RequestBody String body) throws YoungException {
        String result = "";
        User user = null;
        try {
            user = objectMapper.readValue(body, User.class);
            userService.set(user);
            return result;
        } catch (JsonProcessingException e) {
            throw new YoungException(e);
        }
    }

}
