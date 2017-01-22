package com.yyq.holiday.service.country;

import com.yyq.holiday.common.result.Result;
import com.yyq.holiday.common.resultbo.CountryBO;
import com.yyq.holiday.domain.entity.country.CountryDO;

/**
 * @Dscription: 国家业务service层
 * @Created: admin
 * @Date: 2017/1/16 14:52
 * @version: 1.0.0.0
 */
public interface CountryService {


    /**
     * 通过编号查询国家信息
     * @param code 国家编号
     * @return 国家信息
     */
    Result<CountryBO> queryCountryDOByCode(String code);
}
