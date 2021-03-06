package com.yyq.holiday.service.country.impl;

import com.yyq.holiday.common.result.Result;
import com.yyq.holiday.common.resultbo.CountryBO;
import com.yyq.holiday.domain.entity.country.CountryDO;
import com.yyq.holiday.manager.country.CountryManager;
import com.yyq.holiday.service.country.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Dscription: 国家业务service 实现层
 * @Created: admin
 * @Date: 2017/1/16 14:54
 * @version: 1.0.0.0
 */
@Service
@Slf4j
public class CountryServiceImpl implements CountryService{

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryManager countryManager;
    /**
     * 通过编号查询国家信息
     *
     * @param code 国家编号
     * @return 国家信息
     */
    @Override
    public Result<CountryBO> queryCountryDOByCode(String code) {
        //参数校验
        log.info("参数校验方法开始==>{}",code);
        if (1==1){
            throw new RuntimeException("yunxing");
        }
        CountryDO countryDO = countryManager.queryCountryDOByCode(code);
        log.info("方法结束调用");
        return Result.wrapSuccessfulResult(this.convertcountryDO2BO(countryDO));

    }

    /**
     * 对象装换
     * @param countryDO
     * @return
     */
    private CountryBO convertcountryDO2BO(CountryDO countryDO) {
        CountryBO countryBO = new CountryBO();
        if (null == countryDO){
            return countryBO;
        }
        BeanUtils.copyProperties(countryDO,countryBO);
        return countryBO;
    }
}
