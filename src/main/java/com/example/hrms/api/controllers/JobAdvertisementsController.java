package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){return this.jobAdvertisementService.getAll();}

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobAdvertisement jobAdvertisement){return this.jobAdvertisementService.add(jobAdvertisement);}

    @GetMapping("/getAllActiveJobs")
    public DataResult<List<JobAdvertisement>> getAllActive(){return this.jobAdvertisementService.getAllActive();}

    @GetMapping("/getActiveJobOrderByPublishDate")
    public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByPublishDate(){return this.jobAdvertisementService.findByIsActiveTrueOrderByPublishDate();}

    @GetMapping("/getActiveJobByCompanyName")
    public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_CompanyName(String companyName){return this.jobAdvertisementService.findByIsActiveTrueAndEmployer_CompanyName(companyName);}
    @DeleteMapping("/delete")
    public Result delete(int id){return this.jobAdvertisementService.delete(id);}

    @DeleteMapping("/deleteAll")
    public Result deleteAll(){return this.jobAdvertisementService.deleteAll();}

    @PostMapping(value = "/deactivate")
    Result deactivateJobAdvertisement(int id) {
        return this.jobAdvertisementService.deactivateJobAdvertisement(id);
    }
}
