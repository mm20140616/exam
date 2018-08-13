package com.hand.utils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName EncodingFilter
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 10:15
 * @Version 1.0
 **/
public class EncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding") ;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
