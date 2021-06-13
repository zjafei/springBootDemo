package com.spring.l05_web_admin.service;

import com.spring.l05_web_admin.model.City;

public interface CityService {

    public City getById(Long id);

    public void insert(City city);
}
