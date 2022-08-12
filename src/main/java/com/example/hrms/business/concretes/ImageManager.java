package com.example.hrms.business.concretes;

import com.example.hrms.adapters.CloudinaryAdapter;
import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        super();
        this.imageDao = imageDao;
    }

    @Override
    public Result add(MultipartFile file) throws IOException {
        DataResult<Object> result = CloudinaryAdapter.uploadImage(file);
        return new SuccessResult(result.getData().toString());
    }
}