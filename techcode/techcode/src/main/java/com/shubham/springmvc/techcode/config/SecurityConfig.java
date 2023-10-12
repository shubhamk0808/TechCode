package com.shubham.springmvc.techcode.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean	
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		/*
		//Default Configuration
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
		*/
		
		
		//Permit all
		http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
			.formLogin(withDefaults())
			.httpBasic(withDefaults());
		
		return http.build();
		
		
		/*
		//deny all
		http.authorizeHttpRequests(reqs -> reqs.anyRequest().denyAll())
			.formLogin(withDefaults())
			.httpBasic(withDefaults());
		
		return http.build();
		*/
	}
}
