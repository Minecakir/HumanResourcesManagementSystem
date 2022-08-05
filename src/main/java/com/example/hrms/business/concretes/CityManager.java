package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao){
        super();
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"All cities are listed.");
    }

    @Override
    public Result add(City city) {
         if(this.cityDao.existsCitiesByCityName(city.getCityName())) {
             return new ErrorResult("City has already exist!");
         }
        this.cityDao.save(city);
        return new SuccessResult("City is added.");
    }

    @Override
    public Result delete(City city) {
        if(this.cityDao.existsCitiesByCityName(city.getCityName())&&
        this.cityDao.existsById(city.getId()))
        {
            this.cityDao.delete(city);
            return new SuccessResult("City is deleted.");
        }
        return new ErrorResult("City has been not found.");
    }
}
