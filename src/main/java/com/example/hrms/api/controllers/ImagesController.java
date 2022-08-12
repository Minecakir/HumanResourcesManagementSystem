package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        super();
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public Result upload(@RequestPart(name = "file") MultipartFile file) throws IOException {
        return this.imageService.add(file);

    }
}