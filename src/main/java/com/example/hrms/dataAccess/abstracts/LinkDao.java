package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<Link,Integer> {
    Boolean existsByUrl(String url);
}
