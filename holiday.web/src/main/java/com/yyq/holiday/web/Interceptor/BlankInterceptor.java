package com.yyq.holiday.web.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Dscription:
 * @Created: yyq
 * @Date: 2017/2/8 17:48
 * @version: 1.0.0.0
 */
public class BlankInterceptor extends HandlerInterceptorAdapter {
    private  StringBuilder ret = new StringBuilder();

    public String filter(HttpServletRequest request ,String input){
        this.ret.delete(0,ret.length());
        this.ret = this.ret.append(input);
        if (this.ret == null || input.trim().equals(null)){
            return null;
        }
        //去掉参数的空格
        return ret.toString().trim();
    }
    @Override
    public boolean preHandle(final HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Method[] methods = handler.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("test");
        return true;
    }
}
