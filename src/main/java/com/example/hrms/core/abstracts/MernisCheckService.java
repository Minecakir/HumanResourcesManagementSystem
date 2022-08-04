package com.example.hrms.core.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
    public Result checkIfRealPerson(Candidate candidate);
}
