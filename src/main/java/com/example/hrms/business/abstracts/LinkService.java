package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Link;

import java.util.List;

public interface LinkService {
    DataResult<List<Link>> getAll();
    Result add(Link link);
}
