package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao)
    {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers are listed.");
    }

    @Override
    public Result add(Employer employer) {
        if(this.getByEmail(employer.getEmail()).getData()!=null)
        {
            return new ErrorResult("User e-mail has already exist!");
        }
        this.employerDao.save(employer);
        return new SuccessResult("Employer is added.");
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return this.employerDao.existsEmployerByEmail(email) ?
                new SuccessDataResult<Employer>(this.employerDao.getByEmail(email),"Employer is found.")
                :new ErrorDataResult<Employer>("Employer not found!");
    }
}
