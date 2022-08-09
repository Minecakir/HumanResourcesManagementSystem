package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UniversityService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.UniversityDao;
import com.example.hrms.entities.concretes.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {
    private UniversityDao universityDao;

    @Autowired
    public UniversityManager(UniversityDao universityDao){
        super();
        this.universityDao = universityDao;
    }

    @Override
    public DataResult<List<University>> getAll() {
        return new SuccessDataResult<List<University>>(this.universityDao.findAll(),"All universities are listed.");
    }

    @Override
    public Result add(University university) {
        if(this.universityDao.existsByUniversityName(university.getUniversityName())){
            return new ErrorResult("University has already exist.");
        }
        this.universityDao.save(university);
        return new SuccessResult("University is added.");
    }
}
