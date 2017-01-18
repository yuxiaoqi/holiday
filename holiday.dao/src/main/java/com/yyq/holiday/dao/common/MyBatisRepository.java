package com.yyq.holiday.dao.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Dscription:
 * @Created: admin
 * @Date: 2017/1/16 17:48
 * @version: 1.0.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
    String value() default "";
}
