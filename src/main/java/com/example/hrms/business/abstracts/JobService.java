package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    DataResult<List<Job>> getAll();
}
