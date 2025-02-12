package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.abstracts.MernisCheckService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService)
    {
        super();
        this.candidateDao = candidateDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new SuccessDataResult<>(candidateDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<Candidate> getByEmail(String email) {
        return this.candidateDao.existsCandidateByEmail(email) ?
                new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email),"Candidate is found.")
                :new ErrorDataResult<Candidate>("Candidate not found!");
    }

    @Override
    public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
        return this.candidateDao.existsCandidateByIdentityNumber(identityNumber) ?
                new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber),"Candidate is listed.")
                :new ErrorDataResult<Candidate>("Candidate not found!");
    }

    @Override
    public Result add(Candidate candidate) {
        if(this.candidateDao.existsCandidateByEmail(candidate.getEmail()) ||
        this.candidateDao.existsCandidateByIdentityNumber(candidate.getIdentityNumber())) {
            return new ErrorResult("User has already exist!");
        }
        this.candidateDao.save(candidate);
        register(candidate);
        return new SuccessResult("Candidate is added.");
    }

    public Result register(Candidate candidate) {
    candidate.setVerified(false);
    candidateDao.save(candidate);
    emailService.sendVerificationEmail(candidate.getEmail());
    return new SuccessResult("Registration successful. Please verify your email.");
}

    public void sendVerificationEmail(String email) {
    // Logic to send an email with a verification link
}
}
