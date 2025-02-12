package com.example.hrms.business.abstracts;


import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll(int page, int size);

    DataResult<Candidate> getByEmail(String email);

    DataResult<Candidate> getByIdentityNumber(String identityNumber);

    Result add(Candidate candidate);
}
