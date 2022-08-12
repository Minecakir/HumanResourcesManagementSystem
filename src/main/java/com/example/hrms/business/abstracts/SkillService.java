package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Skill;

import java.util.List;

public interface SkillService {
    DataResult<List<Skill>> getAll();
    Result add(Skill skill);
}
