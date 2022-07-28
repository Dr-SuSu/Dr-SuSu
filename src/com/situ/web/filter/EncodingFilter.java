package com.situ.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncodingFilter.init");
    }
    // method = "get" "post"
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("EncodingFilter.doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        // 解决post请求乱码问题
        if (method.equalsIgnoreCase("post")) {
            servletRequest.setCharacterEncoding("UTF-8");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("EncodingFilter.destroy");
    }
}
