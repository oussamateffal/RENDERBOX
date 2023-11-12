package com.renderbox.renderboxporoject.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    public String storeFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File destFile = new File(uploadDirectory + File.separator + fileName);
        file.transferTo(destFile.toPath());
        return "/uploads/" + fileName;
    }
}
