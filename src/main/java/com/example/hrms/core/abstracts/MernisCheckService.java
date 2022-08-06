package com.example.hrms.core.abstracts;

import com.example.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
    public boolean checkIfRealPerson(Candidate candidate);
}
