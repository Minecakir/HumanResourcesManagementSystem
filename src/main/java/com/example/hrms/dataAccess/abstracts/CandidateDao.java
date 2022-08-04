package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    Candidate getByEmail(String email);
    Candidate getByIdentityNumber(String identityNumber);
    Boolean existsCandidateByEmail(String email);
    Boolean existsCandidateByIdentityNumber(String identityNumber);
}
