package com.example.SteDziPanki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {

    @RequestMapping(value = { "/login"}, method = RequestMethod.GET)
    public String getIndex() {
        return "/login";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String postLogin(){
        return "/login";
    }

}
