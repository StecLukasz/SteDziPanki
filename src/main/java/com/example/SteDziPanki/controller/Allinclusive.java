package com.example.SteDziPanki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Allinclusive {

    @RequestMapping(value = {"/allinclusive"}, method = RequestMethod.GET)
    public String getAllinclusive() {
        return "allinclusive";
    }

}