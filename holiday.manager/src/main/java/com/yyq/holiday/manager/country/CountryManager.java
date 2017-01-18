package com.yyq.holiday.manager.country;

import com.yyq.holiday.domain.entity.country.CountryDO;

/**
 * @Dscription: country 业务manager层
 * @Created: by yyq
 * @Date:  2017/1/16.
 * @version: 1.0.0.0
 */
public interface CountryManager {

    /**
     * 通过国家编号查询国家信息
     * @param code 国家编号
     * @return 国家信息
     */
    CountryDO queryCountryDOByCode(String code);
}
