package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    Employer getByEmail(String email);
    Boolean existsEmployerByEmail(String email);
}
