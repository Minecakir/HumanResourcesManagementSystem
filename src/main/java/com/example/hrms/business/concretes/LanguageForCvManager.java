package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LanguageForCvService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageForCvDao;
import com.example.hrms.entities.concretes.LanguageForCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageForCvManager implements LanguageForCvService {
    private LanguageForCvDao languageForCvDao;

    @Autowired
    public LanguageForCvManager(LanguageForCvDao languageForCvDao){super();this.languageForCvDao = languageForCvDao;}

    public DataResult<List<LanguageForCv>> getAll(){return new SuccessDataResult<List<LanguageForCv>>(this.languageForCvDao.findAll(),"Listed all.");};

    public Result add(LanguageForCv languageForCv){
        this.languageForCvDao.save(languageForCv);
        return new SuccessResult("Added.");
    };
}
