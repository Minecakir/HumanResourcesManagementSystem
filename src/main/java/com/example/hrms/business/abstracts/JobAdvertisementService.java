package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAllActive();
    DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByPublishDate();
    DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
    Result delete(int id);
    Result deleteAll();
    Result deactivateJobAdvertisement(int id);
}
