package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.JobDao;
import com.example.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JobManager implements JobService {
    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao){
        super();
        this.jobDao = jobDao;
    }
    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Jobs are listed.");
    }
}
