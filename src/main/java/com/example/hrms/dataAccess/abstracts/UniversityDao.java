package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDao extends JpaRepository<University,Integer> {
    Boolean existsByUniversityName(String universityName);
}
