package com.yyq.holiday.common.result;

import com.yyq.holiday.common.service.ServiceError;
import lombok.Getter;
import lombok.Setter;

/**
 * @Dscription:
 * @Created: admin
 * @Date: 2017/1/16 14:52
 * @version: 1.0.0.0
 */
public class Result <D>{
    @Getter
    @Setter
    private boolean success; //返回 true or false
    @Getter
    @Setter
    private String code;    //错误码
    @Getter
    @Setter
    private String message; //错误信息
    @Getter
    @Setter
    private D data;  //返回数据

/*
    -----------------------STATIC METHONDS--------------------
*/

    public static <D> Result<D> wrapSuccessfulResult(D data) {
        Result<D> result = new Result<>();
        result.data = data;
        result.success = true;
        return result;
    }

    public static <D> Result<D> wrapErrorResult(ServiceError error){
        Result<D> result = new Result<>();
        result.code = error.getCode();
        result.message = error.getMessage();
        result.success = false;
        return result;
    }

    public static <D> Result<D> wrapErrorResult(ServiceError error, Object... messages){
        Result<D> result = new Result<>();
        result.code = error.getCode();
        result.message = String.format(error.getMessage(),messages);
        result.success = false;
        return result;
    }

    public static <D> Result<D> wrapErrorResult(String code, String message){
        Result<D> result = new Result<>();
        result.code = code;
        result.message = message;
        result.success = false;
        return result;
    }
}
