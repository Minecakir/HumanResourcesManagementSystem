package com.example.hrms.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryAdapter {
    static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "",//YOUR CLOUD NAME
            "api_key", "",//YOUR API KEY
            "api_secret", "",//YOUR API SECRET
            "secure", true));

    public static DataResult<Object> uploadImage(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        return new SuccessDataResult<Object>(uploadResult.get("url"));
    }

    public static Result delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return new SuccessResult(result.toString());
    }

    public static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}