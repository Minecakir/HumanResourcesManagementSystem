package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cover_letters")
public class CoverLettersController {
    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService){super(); this.coverLetterService = coverLetterService;}

    @GetMapping("/getAll")
    public DataResult<List<CoverLetter>> getAll(){return this.coverLetterService.getAll();}

    @PostMapping("/add")
    public Result add(CoverLetter coverLetter){return this.coverLetterService.add(coverLetter);}
}
