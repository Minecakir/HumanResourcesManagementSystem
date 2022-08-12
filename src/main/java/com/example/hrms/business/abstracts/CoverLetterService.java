package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {
    DataResult<List<CoverLetter>> getAll();
    Result add(CoverLetter coverLetter);
}
