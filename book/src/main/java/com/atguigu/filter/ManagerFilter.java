package com.atguigu.filter;

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 检查能否进入后台管理，登录就行
 * @author xiu
 * @create 2021-12-10 20:59
 */
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        HttpServletRequest HttpServletRequest= (HttpServletRequest) request;
        HttpSession session = HttpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            httpServletResponse.sendRedirect(HttpServletRequest.getContextPath()+"/pages/user/login.jsp");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
