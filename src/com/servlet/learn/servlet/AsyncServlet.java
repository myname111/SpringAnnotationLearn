package com.servlet.learn.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1.设置异步支持
@WebServlet(value="/async",asyncSupported=true)
public class AsyncServlet extends HttpServlet {
    
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
		//2.开启异步环境
		AsyncContext startAsync = req.startAsync();
		//3.处理业务逻辑
		startAsync.start(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler();
				//4.异步处理完成
				startAsync.complete();
				//5.获取异步上下文
				AsyncContext asyncContext = req.getAsyncContext();
				//6.获取异步响应
				ServletResponse response = asyncContext.getResponse();
				try {
					//7.响应输出
					response.getWriter().write("hello");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
     //业务逻辑
     private void handler(){
    	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
