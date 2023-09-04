package com.yang.springbootyangclub.controller.dashboard;

import com.yang.springbootyangclub.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * package name : com.yang.springbootyangclub.controller.dashboard
 * Date : 2023-09-03
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */

@Controller
public class DashboardController extends BaseController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {


        return getPath("/dashboard");
    }



}
