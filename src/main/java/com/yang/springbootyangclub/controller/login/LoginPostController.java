package com.yang.springbootyangclub.controller.login;

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


    @RequestMapping(value = "/login/register/add", method = RequestMethod.POST)
    public String registerAdd(@RequestBody String body) {
        String result = "";

        User user = new User();

        userService.set(user);
        return result;
    }

}
