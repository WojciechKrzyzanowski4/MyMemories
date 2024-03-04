package com.krzyz.mymemories.controller;

import com.krzyz.mymemories.dto.MemoryDto;
import com.krzyz.mymemories.service.FileService;
import com.krzyz.mymemories.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Controller
public class PrivateController {

    @Autowired
    private FileService fileService;

    @Autowired
    private MemoryService memoryService;

    @GetMapping("/dashboard")
    public String getTheDashboard(){
        return "/dashboard";
    }

    @GetMapping("/addmemory")
    public String memory(){
        return "addmemory";
    }

    @PostMapping("/addmemory/save")
    public String uploadIntoFileSystem(@RequestParam("file") MultipartFile file,
                                       @RequestParam("text") String text) throws IOException{


        if (file.isEmpty()) {
            return "redirect:/addmemory?failure";
        }
        String path = fileService.storeFile(file);
        if (path.isEmpty()) {
            return "redirect:/addmemory?failure";
        }

        MemoryDto memoryDto = new MemoryDto();
        memoryDto.setText(text);
        memoryDto.setImagePath(path);
        memoryService.saveMemory(memoryDto);
        return "redirect:/addmemory?success";
    }

    @GetMapping("/memory")
    public String memory(@RequestParam(name = "memoryId", required = false) int memoryId, Model model){

       //here we will get the url of the memory
        model.addAttribute("memory", "mymemory" );
        return "/memory";
    }
}
