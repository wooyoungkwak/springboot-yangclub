package com.yang.springbootyangclub.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.springbootyangclub.libs.exceptions.YoungException;
import com.yang.springbootyangclub.model.entity.user.domain.User;
import com.yang.springbootyangclub.model.entity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/login/login")
    public String login(@RequestBody String body) throws YoungException {
        try {
            String result = "";
            User user =  objectMapper.readValue(body, User.class);
            return result;
        } catch (JsonProcessingException e) {
            throw new YoungException(e);
        }
    }

    @RequestMapping(value = "/login/register", method = RequestMethod.POST)
    public String register(@RequestBody String body) {
        String result = "";
        User user = new User();
        userService.set(user);
        return result;
    }

}
