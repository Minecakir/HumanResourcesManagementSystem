package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        super();
        this.cvService = cvService;
    }

    @GetMapping("getAll")
    public DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody Cv cv) {
        return this.cvService.add(cv);
    }
    @GetMapping("GetByCandidateId")
    public DataResult<Cv> getCvByCandidate_Id(int id) {return this.cvService.getCvByCandidate_Id(id);}
}
