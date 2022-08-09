package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UniversityDepartmentService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UniversityDepartmentDao;
import com.example.hrms.entities.concretes.UniversityDepartment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityDepartmentManager implements UniversityDepartmentService {
    private UniversityDepartmentDao universityDepartmentDao;

    public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao)
    {
        super();
        this.universityDepartmentDao = universityDepartmentDao;
    }
    @Override
    public DataResult<List<UniversityDepartment>> getAll() {
        return new  SuccessDataResult<List<UniversityDepartment>>(this.universityDepartmentDao.findAll(),"All university departments are listed.");
    }

    @Override
    public Result add(UniversityDepartment universityDepartment) {
        this.universityDepartmentDao.save(universityDepartment);
        return new SuccessResult("University department is added.");
    }
}
