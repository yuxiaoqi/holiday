package com.yyq.holiday.common.annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * @Dscription:
 * @Created: yyq
 * @Date: 2017/1/22 14:58
 * @version: 1.0.0.0
 */
@Inherited
@Retention(RUNTIME)
@Target({METHOD})
public @interface VisitorAccessible {
}
