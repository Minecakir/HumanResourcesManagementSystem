package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UniversityDepartmentService;
import com.example.hrms.business.concretes.UniversityDepartmentManager;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UniversityDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/university_departments")
public class UniversityDepartmentsController {
    private UniversityDepartmentService universityDepartmentService;

    @Autowired
    public UniversityDepartmentsController(UniversityDepartmentManager universityDepartmentService)
    {
        super();
        this.universityDepartmentService = universityDepartmentService;
    }
    @GetMapping("/getAll")
    public DataResult<List<UniversityDepartment>> getAll(){return this.universityDepartmentService.getAll();}
    @PostMapping("add")
    public Result add(UniversityDepartment universityDepartment){return this.universityDepartmentService.add(universityDepartment);}
}
