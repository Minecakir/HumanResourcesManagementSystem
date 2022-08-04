package com.example.hrms.core.concretes;

import com.example.hrms.core.abstracts.MernisCheckService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisCheckAdapter implements MernisCheckService {
    @Override
    public Result checkIfRealPerson(Candidate candidate) {
        return new SuccessResult();
    }
}
