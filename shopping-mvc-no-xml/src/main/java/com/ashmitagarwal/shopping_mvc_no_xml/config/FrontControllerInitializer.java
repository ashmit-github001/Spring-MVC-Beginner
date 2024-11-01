package com.ashmitagarwal.shopping_mvc_no_xml.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class FrontControllerInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		
		webApplicationContext.setConfigLocation("com.ashmitagarwal.shopping_mvc_no_xml.config.AppConfig");
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("mydispatcherServlet", dispatcherServlet);
		
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/shopping.com/*");
		
	}

	
}
