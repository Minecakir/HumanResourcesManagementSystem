package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        super();
        this.userDao = userDao;
    }

    @Override
    public Result deleteAll() {
        this.userDao.deleteAll();
        return new SuccessResult("Deleted all users.");
    }
}
