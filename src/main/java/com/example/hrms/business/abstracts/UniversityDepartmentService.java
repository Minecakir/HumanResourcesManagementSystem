package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UniversityDepartment;

import java.util.List;

public interface UniversityDepartmentService {
    DataResult<List<UniversityDepartment>> getAll();
    Result add(UniversityDepartment universityDepartment);
}
