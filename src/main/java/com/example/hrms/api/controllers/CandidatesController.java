package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @GetMapping("/getByEmail")
    public DataResult<Candidate> getByEmail(@RequestParam String email) {
        return this.candidateService.getByEmail(email);
    }

    @GetMapping("/getByIdentityNumber")
    public DataResult<Candidate> getByIdentityNumber(@RequestParam String identityNumber) {
        return this.candidateService.getByIdentityNumber(identityNumber);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Candidate candidate) {
        return this.candidateService.add(candidate);
    }
}
