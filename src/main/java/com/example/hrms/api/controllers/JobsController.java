package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService){this.jobService = jobService;}

    @GetMapping("/getAll")
    public DataResult<List<Job>> getAll(){return this.jobService.getAll();}

    @PostMapping("/addJob")
    public Result add(@RequestBody Job job) {
        return this.jobService.add(job);
    }
}
