package com.yyq.holiday.service.country.impl;

import com.yyq.holiday.domain.entity.country.CountryDO;
import com.yyq.holiday.manager.country.CountryManager;
import com.yyq.holiday.service.country.CountryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Dscription: 国家业务service 实现层
 * @Created: admin
 * @Date: 2017/1/16 14:54
 * @version: 1.0.0.0
 */
@Service
public class CountryServiceImpl implements CountryService{

    @Resource
    private CountryManager countryManager;
    /**
     * 通过编号查询国家信息
     *
     * @param code 国家编号
     * @return 国家信息
     */
    @Override
    public CountryDO queryCountryDOByCode(String code) {
        return countryManager.queryCountryDOByCode(code);
    }
}
