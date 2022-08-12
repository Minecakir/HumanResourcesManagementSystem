package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UniversityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.University;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
    private UniversityService universityService;

    public UniversitiesController(UniversityService universityService){
        this.universityService = universityService;
    }
    @GetMapping("/getAll")
    public DataResult<List<University>> getAll(){return this.universityService.getAll();}
    @PostMapping("/add")
    public Result add(@Valid @RequestBody University university){return this.universityService.add(university);}
}
