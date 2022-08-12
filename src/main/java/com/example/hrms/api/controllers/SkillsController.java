package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.SkillService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/skills")
public class SkillsController {
    private SkillService skillService;
    @Autowired
    public SkillsController( SkillService skillService){this.skillService = skillService;}

    @GetMapping("/getAll")
    public DataResult<List<Skill>> getAll(){return this.skillService.getAll();}

    @PostMapping("/add")
    public Result add(Skill skill){return this.skillService.add(skill);}
}
