package com.yyq.holiday.common.result;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @Dscription:
 * @Created: yyq
 * @Date: 2017/1/22 14:58
 * @version: 1.0.0.0
 */
public class ErrorResult {
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private Object data;
}
