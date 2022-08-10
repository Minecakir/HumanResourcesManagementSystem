package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDao extends JpaRepository<Cv, Integer> {
    Cv getCvByCandidate_Id(int id);
    Boolean existsByCandidate_Id(int id);
}
