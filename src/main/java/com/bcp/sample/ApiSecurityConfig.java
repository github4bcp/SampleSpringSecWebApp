package com.bcp.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig {/* extends WebSecurityConfigurerAdapter {

	private String tokenKey = "123";

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/person/**")
				.csrf()
				.disable()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.addFilterBefore(rememberMeAuthenticationFilter(),
						BasicAuthenticationFilter.class).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.exceptionHandling()
				.authenticationEntryPoint(new Http403ForbiddenEntryPoint());
	}

	*//**
	 * Remember me config
	 *//*
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(rememberMeAuthenticationProvider());
	}

	@Bean
	public RememberMeAuthenticationFilter rememberMeAuthenticationFilter()
			throws Exception {
		return new RememberMeAuthenticationFilter(authenticationManager(),
				tokenBasedRememberMeService());
	}

	@Bean
	public CustomTokenBasedRememberMeService tokenBasedRememberMeService() {
		CustomTokenBasedRememberMeService service = new CustomTokenBasedRememberMeService(
				tokenKey, userDetailsService);
		service.setAlwaysRemember(true);
		service.setCookieName("at");
		return service;
	}

	@Bean
	RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
		return new RememberMeAuthenticationProvider(tokenKey);
	}*/
}