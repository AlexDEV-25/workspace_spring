package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {

	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		// được ưu tiên hơn trong application.properties
//		UserDetails alex = User.withUsername("alex").password("{noop}123456").roles("teacher").build();
//		UserDetails duc = User.withUsername("duc").password("{noop}123456").roles("manager").build();
//		UserDetails moi = User.withUsername("moi").password("{noop}123456").roles("admin").build();
//		return new InMemoryUserDetailsManager(alex, duc, moi);
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "api/students")
				.hasAnyRole("TEACHER", "MANAGER", "ADMIN").requestMatchers(HttpMethod.GET, "api/students/**")
				.hasAnyRole("TEACHER", "MANAGER", "ADMIN").requestMatchers(HttpMethod.POST, "api/students")
				.hasAnyRole("MANAGER", "ADMIN").requestMatchers(HttpMethod.PUT, "api/students")
				.hasAnyRole("MANAGER", "ADMIN").requestMatchers(HttpMethod.DELETE, "api/students/**")
				.hasAnyRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());// không thể giả mạo action
		return http.build();
	}
}
