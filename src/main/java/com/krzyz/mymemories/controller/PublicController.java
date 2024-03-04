package com.krzyz.mymemories.controller;

import com.krzyz.mymemories.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class PublicController {

    @Autowired
    FileService fileService;

    @GetMapping("/home")
    public String home() {
        return "/home";
    }


    //extra control controllers
    @GetMapping("/image")
    public String image(Model model) throws IOException{
        var input = fileService.getFile("D:\\Data\\MemoryImages\\storage\\dupa.jpg");
        model.addAttribute("srcStr64", input);
        return "/image";
    }


}
