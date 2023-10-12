package com.shubham.springmvc.techcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean	
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		//defining custom security configuration - permitAll, denyAll, authenticated		
		http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests.requestMatchers("", "/", "/home").permitAll()
				.requestMatchers("/about").permitAll()
				.requestMatchers("/courses").authenticated()
				.requestMatchers("/holidays/**").permitAll()
				.requestMatchers("/contact").denyAll()
				.requestMatchers("/saveUserQuery").permitAll()
				.requestMatchers("/assets/**").permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		return http.build();
		
		/*
		//Default Configuration
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
		*/
		
		/*
		//Permit all
		http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
			.formLogin(withDefaults())
			.httpBasic(withDefaults());
		
		return http.build();
		*/
		
		/*
		//deny all
		http.authorizeHttpRequests(reqs -> reqs.anyRequest().denyAll())
			.formLogin(withDefaults())
			.httpBasic(withDefaults());
		
		return http.build();
		*/
	}
}
