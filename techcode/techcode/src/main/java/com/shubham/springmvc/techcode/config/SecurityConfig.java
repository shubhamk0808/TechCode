package com.shubham.springmvc.techcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean	
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		//defining custom security configuration - permitAll, denyAll, authenticated		
		http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests((requests) -> requests.requestMatchers("", "/", "/home").permitAll()				
				.requestMatchers("/about").permitAll()
				.requestMatchers("/courses").permitAll()
				.requestMatchers("/holidays/**").permitAll()
				.requestMatchers("/contact").authenticated()
				.requestMatchers("/saveUserQuery").permitAll()
				.requestMatchers("/login").permitAll()
				.requestMatchers("/assets/**").permitAll())
				//to define our own custom login page
				.formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll())
				.logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
						.invalidateHttpSession(true).permitAll())//using query params logout=true to indicate
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
	

	/*
	@Bean
	public UserDetailsService usersDetails() {
		 UserDetails admin = User.builder()
				 .username("admin")
//				 .password(passwordEncoder().encode("12345"))
				 .password("12345")
				 .roles("ADMIN", "USER")
				 .build();
		 
		 UserDetails user = User.builder()
				 .username("user")
				 .password(passwordEncoder().encode("54321"))
				 .roles("USER")
				 .build();
		 
		 return new InMemoryUserDetailsManager(admin, user);
	}
	*/
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
            .password(passwordEncoder().encode("12345"))
            .roles("USER")
            .build();
        
        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder().encode("54321"))
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
