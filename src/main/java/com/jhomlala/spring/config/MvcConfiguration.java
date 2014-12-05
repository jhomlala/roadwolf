package com.jhomlala.spring.config;
 
import java.util.Properties;

import javax.sql.DataSource;

import com.jhomlala.spring.dao.BusStopDAO;
import com.jhomlala.spring.dao.BusStopDAOImpl;
import com.jhomlala.spring.dao.CourseDAO;
import com.jhomlala.spring.dao.CourseDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{ 

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public SimpleMappingExceptionResolver getExceptionResolver()
	{
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties properties = new Properties();
		properties.put("com.jhomlala.spring.controller.SpringException","error");
		//properties.put("defaultErrorView","ExceptionPage");
		resolver.setExceptionMappings(properties);
		return resolver;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/roadwolf");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	public CourseDAO getCourseDAO() {
		return new CourseDAOImpl(getDataSource());
	}
	@Bean
	public BusStopDAO getBusStopDAO() {
		return new BusStopDAOImpl(getDataSource());
	}

}
