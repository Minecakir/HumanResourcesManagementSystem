package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UniversityDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDepartmentDao extends JpaRepository<UniversityDepartment, Integer> {
}
