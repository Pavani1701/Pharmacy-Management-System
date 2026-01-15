package com.pharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Views {
	
	@RequestMapping("/")
    public String start() {
        return "index";
    }

}
