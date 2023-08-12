package com.yang.springbootyangclub.controller.login;

import com.yang.springbootyangclub.controller.BaseController;
import com.yang.springbootyangclub.model.entity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * package name : com.young.springbootstarbucks.controller
 * Date : 2023-05-01
 * Author : zilet
 * Project : springboot-starbucks
 * Description :
 */

@Controller
@RequiredArgsConstructor
public class LoginController extends BaseController {

    private final UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView redirect() {

        return new RedirectView("/login/login");
    }

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {

        return  getPath("/login");
    }

    @RequestMapping(value = "/login/register", method = RequestMethod.GET)
    public String register() {

        return  getPath("/register");
    }

}
