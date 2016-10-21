package com.apsutil.webapp.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(userDetailsService);
		
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").access("hasRole('USER')")
		.antMatchers("/admin**").access("hasRole('USER') and hasRole('ADMIN')")
		.antMatchers("/dba**").access("hasRole('ADMIN') and hasRole('DBA')")
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").successHandler(getSimpleUrlAuthenticationSuccessHandler())
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
		
	}
	
	/*@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
	return new BCryptPasswordEncoder();
	}
	  */
	@Bean
	public SimpleUrlAuthenticationSuccessHandler getSimpleUrlAuthenticationSuccessHandler(){
		SimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler= new SimpleUrlAuthenticationSuccessHandler();
		return authenticationSuccessHandler;
	}
}

/*
 * <beans:beans xmlns="http://www.springframework.org/schema/security"
    xmlns:beans="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
    http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-4.0.xsd">
      
    <http auto-config="true" >
        <intercept-url pattern="/" access="permitAll" />
        <intercept-url pattern="/home" access="permitAll" />
        <intercept-url pattern="/admin**" access="hasRole('ADMIN')" />
        <intercept-url pattern="/dba**" access="hasRole('ADMIN') and hasRole('DBA')" />
        <form-login  login-page="/login"
                     username-parameter="ssoId"
                     password-parameter="password"
                     authentication-failure-url="/Access_Denied" />
        <csrf/>
    </http>
  
    <authentication-manager >
        <authentication-provider user-service-ref="customUserDetailsService"/>
    </authentication-manager>
      
    <beans:bean id="customUserDetailsService" class="com.websystique.springsecurity.service.CustomUserDetailsService" />
     
</beans:beans>
*/
