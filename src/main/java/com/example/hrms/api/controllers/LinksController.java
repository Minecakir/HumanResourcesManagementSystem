package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/links")
public class LinksController {
    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService){this.linkService = linkService;}

    @GetMapping("/getAll")
    public DataResult<List<Link>> getAll(){return this.linkService.getAll();}

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Link link) {return this.linkService.add(link);}
}
