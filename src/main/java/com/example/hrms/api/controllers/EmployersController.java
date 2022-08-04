package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){this.employerService = employerService;}

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){return this.employerService.getAll();}

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Employer employer) {
        return this.employerService.add(employer);
    }

    @GetMapping("/getByEmail")
    public DataResult<Employer> getByEmail(@RequestParam String email){return this.employerService.getByEmail(email);}

}
