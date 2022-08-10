package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.ForeignLanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foreign_languages")
public class ForeignLanguagesController {
    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService){this.foreignLanguageService = foreignLanguageService;}

    @GetMapping("/getAll")
    DataResult<List<ForeignLanguage>> getAll(){return this.foreignLanguageService.getAll();};

    @PostMapping("add")
    Result add(ForeignLanguage foreignLanguage){return this.foreignLanguageService.add(foreignLanguage);}
}
