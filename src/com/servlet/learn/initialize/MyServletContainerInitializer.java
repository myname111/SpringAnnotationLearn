package com.servlet.learn.initialize;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.HandlesTypes;

import com.servlet.learn.filter.NewFilter;
import com.servlet.learn.listener.NewListener;
import com.servlet.learn.service.UserService;
import com.servlet.learn.servlet.MyServlet;
//绑定感兴趣的类类型,被绑定的类的子类/实现类/子类都会被添加到onStartup方法set参数中来
@HandlesTypes(value={UserService.class})
public class MyServletContainerInitializer implements
		ServletContainerInitializer {
    //可以动态添加servlet三大组件:serlvet,fliter,listener
	//不过只能在容器启动的时候添加,容器运行过程中无法完成添加
	@Override
	public void onStartup(Set<Class<?>> set, ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("通过@HandlesTypes添加到set容器中的类类型有:");
		for (Class<?> class1 : set) {
			System.out.println(class1.getName());
		}
		
		//注册servlet
		ServletRegistration.Dynamic addServlet = servletContext.addServlet("newServlet", MyServlet.class);
		//设置servlet的映射
		addServlet.addMapping("/newServlet");
		
		//注册Filter
		FilterRegistration.Dynamic addFilter = servletContext.addFilter("newFilter", NewFilter.class);
		//设置Filter的映射
		addFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
		//注册Listener
		servletContext.addListener(NewListener.class);
	}

}
