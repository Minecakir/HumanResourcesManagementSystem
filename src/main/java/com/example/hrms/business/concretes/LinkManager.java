package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.LinkDao;
import com.example.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkManager implements LinkService {
    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao){super();this.linkDao = linkDao;}

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(this.linkDao.findAll(),"Listed all links.");
    }

    @Override
    public Result add(Link link) {
        if(this.linkDao.existsByUrl(link.getUrl())){return new ErrorResult("Link has already exist.");}
            this.linkDao.save(link);
            return new Result(true,"Added link.");
    }
}
