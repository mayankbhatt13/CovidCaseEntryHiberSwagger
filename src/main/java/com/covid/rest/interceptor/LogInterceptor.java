package com.covid.rest.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{
	
	static Logger logger = Logger.getLogger(LogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LogInterceptor -  preHandle");
		logger.info("LogInterceptor -  preHandle");
		logger.info("url :- "+ request.getRequestURL().toString());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		logger.info("Date : "+simpleDateFormat.format(new Date()));
		//System.out.println("By Get Reader	 "+request.getReader().readLine());
		//System.out.println("By input Stream "+request.getInputStream().read());
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("LogInterceptor -  postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("LogInterceptor -  afterCompletion");
		logger.info("=========================================");
	}
}
