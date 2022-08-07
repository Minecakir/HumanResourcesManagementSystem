package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> findByIsActiveTrue();
    List<JobAdvertisement> findByIsActiveTrueOrderByPublishDate();
    List<JobAdvertisement> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
    Result deleteById(int id);
    Boolean existsById(int id);
    JobAdvertisement getById(int id);
}
