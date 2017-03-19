package com.yyq.holiday.test.country;

import com.yyq.holiday.common.result.Result;
import com.yyq.holiday.common.resultbo.CountryBO;
import com.yyq.holiday.domain.entity.country.CountryDO;
import com.yyq.holiday.service.country.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @Dscription: 国家信息测试类
 * @Created: admin
 * @Date: 2017/1/16 15:02
 * @version: 1.0.0.0
 */
@ContextConfiguration(locations = {"classpath:/holiday/web/application-context.xml"})
@Transactional
@Slf4j
public class CountryTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private CountryService countryService;

    @Test
    public void testGetInfo(){
        String code = "ABW";
        Result<CountryBO> result = countryService.queryCountryDOByCode(code);
        log.info("test---结果{}",result);
    }
}
