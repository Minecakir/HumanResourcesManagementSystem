package com.example.hrms.dataAccess.abstracts;


import com.example.hrms.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job,Integer> {

}
