package com.krzyz.mymemories.controller;

import com.krzyz.mymemories.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class PublicController {

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/memory")
    public String memory(){
        return "/memory";
    }

    @PostMapping("/upload")
    public String uploadIntoFileSystem(@RequestParam("file") MultipartFile file) throws IOException {

        //here the image will be processed




        return "redirect:/memory?success";
    }

}
