package com.yyq.holiday.common.service;

import com.yyq.holiday.common.result.ErrorResult;

/**
 * @Dscription: 错误服务了类
 * @Created: yyq
 * @Date: 2017/1/22 14:56
 * @version: 1.0.0.0
 */
public interface ServiceError {

    String getCode();

    String getMessage();

    ErrorResult toErrorResult(Object... args );

    int getHttpStattusCode();
}
