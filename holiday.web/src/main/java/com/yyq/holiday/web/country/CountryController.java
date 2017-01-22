package com.yyq.holiday.web.country;

import com.yyq.holiday.common.result.Result;
import com.yyq.holiday.common.resultbo.CountryBO;
import com.yyq.holiday.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Dscription: 国家controller
 * @Created: admin
 * @Date: 2017/1/18 11:44
 * @version: 1.0.0.0
 */
@Controller
@RequestMapping("country/count")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @ResponseBody
    @RequestMapping("/query")
    public Result<CountryBO>  queryCountryInfoByCode(String code){
        return countryService.queryCountryDOByCode(code);
    }


}
