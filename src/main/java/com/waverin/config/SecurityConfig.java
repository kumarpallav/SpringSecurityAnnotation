package com.waverin.config;

import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configurable

@ComponentScan(basePackages = {"com.waverin"})

@Import(DatabaseConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	/**
	 * 
	 */
	@Override
	protected void configure(HttpSecurity security) throws Exception{
		security.formLogin()
			.loginPage("/login").
			loginProcessingUrl("/login/authenticate")
			.defaultSuccessUrl("/index")
			.usernameParameter("username")
	        .passwordParameter("password").
			failureUrl("/login?error=login_failed").
		and().logout()
			.deleteCookies("JSESSIONID").
			logoutUrl("/logout")
			.logoutSuccessUrl("/login").
		and().authorizeUrls()
		.antMatchers("/**").permitAll().antMatchers("/admin/").hasRole("USER");

	}
	@Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/assets/**"); // #3
	  }
	
	@Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
       /* auth
            .inMemoryAuthentication()
                .withUser("pallav")
                    .password("pallav")
                    .roles("ADMIN");*/
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")               
        .authoritiesByUsernameQuery("select username as principal, authority as role from  authorities where username = ?")  ;              
        
    }
	/**
	 * 
	 * @return
	 */
	/**
	 * Important FINAL CONSTANTS :)
	 */
	

	
	

}
