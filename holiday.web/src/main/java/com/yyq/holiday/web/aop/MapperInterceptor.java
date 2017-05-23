package com.yyq.holiday.web.aop;


import com.yyq.holiday.domain.entity.base.BaseEntity;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MapperInterceptor implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objs, Object object) throws Throwable {
        Class<?> entityClass = method.getDeclaringClass();

        BaseEntity domain = null;
        if (ArrayUtils.isNotEmpty(objs)) {
            for (Object obj : objs) {
                if (obj instanceof BaseEntity) {
                    domain = (BaseEntity) obj;
                    break;
                }
            }
        }

        if (domain != null) {
            // 数据库创建和更新时间添加
            if (method.getName().startsWith("insert")) {
                Date createdAt = domain.getGmtCreate();
                if (createdAt == null) {
                    domain.setGmtCreate(new Date());
                }
                domain.setGmtModified(new Date());
            } else if (method.getName().startsWith("update")) {
                domain.setGmtModified(new Date());
            }
        }
    }
}

