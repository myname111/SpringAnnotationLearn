package com.servlet.learn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class NewListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent var1) {
		// TODO Auto-generated method stub
          System.out.println("NewListener....contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent var1) {
		// TODO Auto-generated method stub
         System.out.println("NewListener......contextInitialized");
	}

}
