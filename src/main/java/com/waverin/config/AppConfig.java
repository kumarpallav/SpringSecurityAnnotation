package com.waverin.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.waverin"})

@PropertySource("classpath:database.properties")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	 @Resource  
     private Environment env;  
       
      
	/**
	 * Add Files Paths Not To be recognized With Sprig MVC 
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/").setCachePeriod(31556926);
	}
	/**
	 * Make and entry for  mvc:default-servlet-handler
	 */
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	 /**
	  * Adding Default View Resolver
	  * @return
	  */
	 @Bean
	    public InternalResourceViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/jsp/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	 

	   
	  
}
