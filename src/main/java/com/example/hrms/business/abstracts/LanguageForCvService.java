package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.LanguageForCv;

import java.util.List;

public interface LanguageForCvService {
    DataResult<List<LanguageForCv>> getAll();
    Result add(LanguageForCv languageForCv);
}
