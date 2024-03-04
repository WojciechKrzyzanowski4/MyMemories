package com.krzyz.mymemories.service.impl;

import com.krzyz.mymemories.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileServiceImpl implements FileService {

    @Override
    public String storeFile(MultipartFile file) throws IOException {

        try{
            byte[] bytes = file.getBytes();
            StringBuilder stringBuilder = new StringBuilder();
            for(byte b : bytes){
                stringBuilder.append(b);
            }
            System.out.println(stringBuilder.toString());
        }catch(IOException i){
            i.printStackTrace();
            return "redirect:/memory?failure";
        }


        return  "success";
    }
}
