package com.blogspot.rkacode.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @RequestMapping(value = "/account/login")
    public ModelAndView loginAction() {
        return new ModelAndView("account/login");
    }
}
