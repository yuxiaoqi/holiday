package com.yyq.holiday.manager.country.impl;

import com.yyq.holiday.dao.country.CountryDODao;
import com.yyq.holiday.domain.entity.country.CountryDO;
import com.yyq.holiday.manager.country.CountryManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Dscription: 业务country实现层
 * @Created: admin
 * @Date: 2017/1/16 14:44
 * @version: 1.0.0.0
 */
@Component
public class CountryManagerImpl implements CountryManager{

    @Resource
    private CountryDODao countryDODao;
    /**
     * 通过国家编号查询国家信息
     *
     * @param code 国家编号
     * @return 国家信息
     */
    public CountryDO queryCountryDOByCode(String code) {
        return countryDODao.selectByPrimaryKey(code);
    }
}
