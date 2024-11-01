package com.ashmitagarwal.shopping_mvc_no_xml_easy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.ashmitagarwal.shopping_mvc_easy_no_xml.controllers")
public class AppConfig {

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".html");
//		viewResolver.setPrefix("/WEB-INF/views/");
//		viewResolver.setSuffix(".html");
		return viewResolver;
	}	
}
