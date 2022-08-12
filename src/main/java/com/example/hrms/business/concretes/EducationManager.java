package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao){super(); this.educationDao = educationDao;}

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Listed all educations.");
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Education is added.");
    }
}
