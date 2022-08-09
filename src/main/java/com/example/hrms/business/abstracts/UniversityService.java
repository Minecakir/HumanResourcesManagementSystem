package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.University;

import java.util.List;

public interface UniversityService {
    DataResult<List<University>> getAll();
    Result add(University university);
}
