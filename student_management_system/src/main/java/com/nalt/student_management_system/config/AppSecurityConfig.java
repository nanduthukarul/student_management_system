package com.nalt.student_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig{
		
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.requestMatchers("/student/new","/student/byName/**","/student/course/**","/student/assisnCourse/**","/course/new").hasRole("ADMIN")
			.requestMatchers("/student/all","/course/all","/student/updateProfile","/course/student/**","/student/leaveCourse/**","/login").permitAll()
			.and()
			.httpBasic();
		
		return http.build();		
	}
	
	@Bean
 	public UserDetailsService userDetailsService() {
 		
 		UserDetails admin = User.withDefaultPasswordEncoder()
 			.username("admin")
 			.password("password")
 			.roles("ADMIN", "USER")
 			.build();
 		return new InMemoryUserDetailsManager(admin);
 	}


	
}
