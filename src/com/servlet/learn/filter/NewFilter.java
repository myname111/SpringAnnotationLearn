package com.servlet.learn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NewFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
       System.out.println("NewFilter....destroy");
	}

	@Override
	public void doFilter(ServletRequest var1, ServletResponse var2,
			FilterChain var3) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器执行");
		var3.doFilter(var1, var2);
	}

	@Override
	public void init(FilterConfig var1) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("NewFilter....init");
	}

}
