package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Result add(MultipartFile file) throws IOException;
}
