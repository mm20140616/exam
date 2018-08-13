package com.hand.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName Exam-19499-20180813-1
 * @ClassName LoginFilter
 * @Description TODO
 * @Author 赵晓宇
 * @Date 2018/8/13 11:28
 * @Version 1.0
 **/
public class LoginFilter implements Filter {
    String[] exclude;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.exclude = filterConfig.getInitParameter("exclude").replace(" ", "").split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest ;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI() ;
        for(String s : exclude){
            if(path.contains(s)){
                filterChain.doFilter(servletRequest, servletResponse);
                return ;
            }
        }

        Object obj = request.getSession().getAttribute("loginUser") ;
        if(obj == null){
            response.sendRedirect("timeout.jsp");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
