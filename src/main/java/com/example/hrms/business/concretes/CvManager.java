package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CvDao;
import com.example.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    @Autowired
    public CvManager(CvDao cvDao) {
        super();
        this.cvDao = cvDao;
    }
    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Listed all cvs.");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv is added.");
    }

    public DataResult<Cv> getCvByCandidate_Id(int id) {
            return new SuccessDataResult<Cv>(this.cvDao.getCvByCandidate_Id(id), "Cv is found.");
    }
}
