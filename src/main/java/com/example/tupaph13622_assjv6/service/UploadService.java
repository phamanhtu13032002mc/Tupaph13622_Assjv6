package com.example.tupaph13622_assjv6.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {

    File save(MultipartFile file, String folder);

}