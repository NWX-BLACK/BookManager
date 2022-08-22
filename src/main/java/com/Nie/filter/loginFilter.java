package com.Nie.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class loginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");

        //不过滤的uri
        String[] notFilter = new String[]{"/","/login/login","/register","/toRegister","/login/toHome"};

        //请求的uri
        String uri = httpServletRequest.getRequestURI();
//        System.out.println("filter>>>uri>>>"+uri);

        //是否过滤
        boolean doFilter = true;
        for(String s : notFilter){
            String route = uri.split("\\?")[0];
            if(s.equals(uri)){
                //uri中包含不过滤uri，则不进行过滤
                doFilter = false;
                break;
            }
        }
//        System.out.println("中文");
        if(doFilter){
            String loginUser = (String) httpServletRequest.getSession().getAttribute("loginUser");

            if(loginUser==null || loginUser==""){
                httpServletResponse.sendRedirect("/login/login?msg="+URLEncoder.encode("请先登录","UTF-8"));
                return;
            }
        }
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
