package com.portfolio.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICloudinaryService {

    String uploadBanner(MultipartFile file) throws IOException;

}
