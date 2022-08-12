package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CoverLetterDao;
import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoverLetterManager implements CoverLetterService {
    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao){super();this.coverLetterDao = coverLetterDao;}

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll(),"Listed all cover letters.");
    }

    @Override
    public Result add(CoverLetter coverLetter) {
        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("Added cover letter.");
    }
}
