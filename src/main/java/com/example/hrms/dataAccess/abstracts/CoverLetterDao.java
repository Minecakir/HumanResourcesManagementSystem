package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
}
