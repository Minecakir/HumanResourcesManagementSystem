package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getAll();
    Result add(Cv cv);
    DataResult<Cv> getCvByCandidate_Id(int id);
}
