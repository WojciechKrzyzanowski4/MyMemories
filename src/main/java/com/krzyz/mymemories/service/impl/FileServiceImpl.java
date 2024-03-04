package com.krzyz.mymemories.service.impl;

import com.krzyz.mymemories.service.FileService;

import java.io.FileNotFoundException;
import java.util.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class FileServiceImpl implements FileService {

    private final String FILE_PATH = "D:\\Data\\MemoryImages\\storage";

    @Override
    public String storeFile(MultipartFile file) throws IOException {

        try{
            //saving the file in the path
            Path path = Paths.get(FILE_PATH + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path);

        }catch(IOException i){
            i.printStackTrace();
            return "";
        }

        return Paths.get(FILE_PATH + "/" + file.getOriginalFilename()).toString();
    }

    @Override
    public String getFile(String filePath) throws IOException{
        String base64File = "";
        File file = new File(filePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            byte fileData[] = new byte[(int) file.length()];
            imageInFile.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
        return base64File;
    }
}
