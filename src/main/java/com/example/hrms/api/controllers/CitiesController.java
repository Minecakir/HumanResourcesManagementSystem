package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService){this.cityService = cityService;}

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll(){return this.cityService.getAll();}

    @PostMapping("/add")
    public Result add(@Valid @RequestBody City city){return this.cityService.add(city);}

    @DeleteMapping("/delete")
    public Result delete(@RequestBody City city){return this.cityService.delete(city);}

}
