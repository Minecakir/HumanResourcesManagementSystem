package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.LanguageForCvService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.LanguageForCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languagesfor_cv")
public class LanguageForCvsController {
    private LanguageForCvService languageForCvService;
    @Autowired
    public LanguageForCvsController(LanguageForCvService languageForCvService){this.languageForCvService = languageForCvService;}

    @GetMapping("/getAll")
    public DataResult<List<LanguageForCv>> getAll(){return this.languageForCvService.getAll();};

    @PostMapping("/add")
    public Result add(LanguageForCv languageForCv){return this.languageForCvService.add(languageForCv);};
}
