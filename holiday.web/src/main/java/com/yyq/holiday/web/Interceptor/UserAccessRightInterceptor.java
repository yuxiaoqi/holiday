package com.yyq.holiday.web.Interceptor;


import com.yyq.holiday.common.annotations.VisitorAccessible;
import com.yyq.holiday.common.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Dscription:
 * @Created: yyq
 * @Date: 2017/2/8 17:48
 * @version: 1.0.0.0
 */
@Component
public class UserAccessRightInterceptor implements HandlerInterceptor {

/*
    @Autowired
    private AdminService adminService;
*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Accept,X-Requested-With,remember-me,bid,accessToken");

        String accessToken = request.getHeader("accessToken");

        if (StringUtils.isNotEmpty(accessToken)) {
            if (!hasPermission(accessToken)) {
                throw new ApplicationException("无效的token");
            }
        } else {
            HandlerMethod handlerMethod = (HandlerMethod) o;
            VisitorAccessible annotation = handlerMethod.getMethodAnnotation(VisitorAccessible.class);
            if (annotation != null) {
                return true;
            }

            if (!request.getMethod().equals("OPTIONS")) {
                if (!handlerMethod.getMethod().getName().toUpperCase().equals("LOGIN")) {
                    throw new ApplicationException("需要登陆才能访问");
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private Boolean hasPermission(String accessToken) {
        //// TODO: 2016/10/27 这里需要接入缓存 但是阿里云本地不可用 所以这里会根据环境来进行处理
        //Admin admin = adminService.getByAccessToken(accessToken);
        if ("Admin" == null) {
            return false;
        }
        return true;
    }
}
