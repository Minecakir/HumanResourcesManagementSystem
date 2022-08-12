package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.SkillService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.SkillDao;
import com.example.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillManager implements SkillService {
    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao){this.skillDao = skillDao;}

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(),"Listed all skills.");
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new Result(true,"Added skill.");
    }
}
