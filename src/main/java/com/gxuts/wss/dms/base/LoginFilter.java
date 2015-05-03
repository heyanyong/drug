package com.gxuts.wss.dms.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req=(HttpServletRequest) request;
		 HttpServletResponse resp=(HttpServletResponse) response;
		 String url=req.getRequestURI();
		 if((req.getSession(true).getAttribute("loginUser")!=null)||url.contains("ogin")||url.contains("register")){
//			 UserInfo user=new UserInfo();
//			 user.setId(100);
//			 user.setNo("admin");
//			 user.setName("admin");
//			 req.getSession(true).setAttribute("loginUser", user);
			 chain.doFilter(request, response);
		 }else if (req.getHeader("X-Requested-With") != null) {
			 resp.getWriter().write("{\"message\":\"登陆超时\",\"statusCode\":\"301\"}");
		 }else{
			 resp.sendRedirect("/drug/login.jsp");
			 
		 }
	}

	@Override
	public void destroy() {
	}

}
