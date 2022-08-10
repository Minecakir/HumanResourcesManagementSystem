package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer> {
}
