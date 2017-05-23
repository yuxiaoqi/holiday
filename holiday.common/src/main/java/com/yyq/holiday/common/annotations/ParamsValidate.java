package com.yyq.holiday.common.annotations;

import java.lang.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * User: yujianfu (mr.vencnet@gmail.com)
 * Date: 16/8/24
 * Time: 下午1:48
 */
@Inherited
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsValidate {

    String description() default "";
}