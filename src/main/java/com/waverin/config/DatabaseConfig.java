package com.waverin.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.waverin")
@PropertySource("classpath:database.properties")
public class DatabaseConfig {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.driverClassName";  
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.password";  
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc.url";  
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.username";
    


    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    //Lets get Environment Green , Add it
    @Resource
    private Environment env;  
      
    @Bean
    public DataSource dataSource() {  
            DriverManagerDataSource dataSource = new DriverManagerDataSource();  
            dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));  
            dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));  
            dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));  
            dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));  
              
            return dataSource;  
    }  
    @Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactoryBean.setHibernateProperties(hibProperties());
		return sessionFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, 
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;	
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
  

}
