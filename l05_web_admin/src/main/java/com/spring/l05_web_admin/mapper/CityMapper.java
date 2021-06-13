package com.spring.l05_web_admin.mapper;

import com.spring.l05_web_admin.model.City;

import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    // @Select("INSERT INTO city(`name`, `state`, `country`) VALUES(#{name}, #{state}, #{country})")
    // @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);
}
