package com.yyq.holiday.dao.country;


import com.yyq.holiday.domain.entity.country.CountryDO;
import com.yyq.holiday.dao.common.MyBatisRepository;

@MyBatisRepository
public interface CountryDODao {
    int deleteByPrimaryKey(String code);

    int insert(CountryDO record);

    int insertSelective(CountryDO record);

    CountryDO selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(CountryDO record);

    int updateByPrimaryKey(CountryDO record);
}