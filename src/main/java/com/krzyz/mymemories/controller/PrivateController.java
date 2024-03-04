package com.krzyz.mymemories.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateController {

    @GetMapping("/dashboard")
    public String getTheDashboard(){
        return "/dashboard";
    }
}
