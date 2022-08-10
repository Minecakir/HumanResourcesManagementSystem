package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.LanguageForCv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageForCvDao extends JpaRepository<LanguageForCv, Integer> {
}
