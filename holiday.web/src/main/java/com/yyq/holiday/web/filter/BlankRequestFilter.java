package com.yyq.holiday.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Dscription: 请求参数的前后空串过滤Filter
 * @Created: yyq
 * @Date: 2017/2/6 17:24
 * @version: 1.0.0.0
 */
public class BlankRequestFilter extends OncePerRequestFilter{
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
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(new HttpServletRequestWrapper(request){
            @Override
            public String getParameter(String name) {
                return filter(this,super.getParameter(name));
            }

            @Override
            public String[] getParameterValues(String name) {
                String[] rets = super.getParameterValues(name);
                if (null == rets){
                    return null;
                }
                for (int i =0 ;i<rets.length ; i++){
                    rets[i] = filter(this,rets[i]);
                }
                return rets;
            }
        },response);

    }
}
