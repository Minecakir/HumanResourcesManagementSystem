package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
}
