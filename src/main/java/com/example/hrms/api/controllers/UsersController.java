package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService){this.userService = userService;}

    @DeleteMapping("/deleteAll")
    public Result deleteAll(){return this.userService.deleteAll();}
}
