package com.spring.l05_web_admin.implement;

import com.spring.l05_web_admin.mapper.CityMapper;
import com.spring.l05_web_admin.model.City;
import com.spring.l05_web_admin.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    };

    public void insert(City city){
        cityMapper.insert(city);
    };
}
