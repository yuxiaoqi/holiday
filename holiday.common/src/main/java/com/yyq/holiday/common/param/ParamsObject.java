package com.yyq.holiday.common.param;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yujianfu (mr.vencnet@gmail.com)
 * Date: 2016/10/9
 * Time: 上午11:32
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ParamsObject implements Serializable {
    /**
     *
     */
    public abstract void validate();
}
