package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService){super(); this.educationService = educationService;}

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll(){return this.educationService.getAll();}

    @PostMapping("/add")
    public Result add(Education education){return this.educationService.add(education);}
}
