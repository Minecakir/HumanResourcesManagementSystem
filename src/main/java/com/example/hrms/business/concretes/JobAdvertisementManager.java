package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao ){
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }
    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(),"All job advertisements are listed.");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job advertisement is added.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),"Active jobs are listed.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByPublishDate() {

        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findByIsActiveTrueOrderByPublishDate(),"Active jobs listed order by publish date");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_CompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_CompanyName(companyName));
    }

    @Override
    public Result delete(int id) {
         if (this.jobAdvertisementDao.existsById(id))
         {
                this.jobAdvertisementDao.deleteById(id);
                return new SuccessResult("Job advertisement is deleted.");}
         return new ErrorResult("Job advertisement not found");
    }

    @Override
    public Result deleteAll() {
        this.jobAdvertisementDao.deleteAll();
        return new SuccessResult("All job advertisements are deleted.");
    }

    @Override
    public Result deactivateJobAdvertisement(int id) {
        if(this.jobAdvertisementDao.existsById(id)){
            JobAdvertisement updatedJobAdvertisement;
            updatedJobAdvertisement = this.jobAdvertisementDao.getById(id);
            updatedJobAdvertisement.setIsActive(false);
            this.jobAdvertisementDao.save(updatedJobAdvertisement);
            return new SuccessResult("Job advertisement deactivated.");
        }
        return new ErrorResult("No job advertisement found.");
    }
}
