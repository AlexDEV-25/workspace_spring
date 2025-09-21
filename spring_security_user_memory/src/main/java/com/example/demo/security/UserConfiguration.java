package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfiguration {
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		// được ưu tiên hơn trong application.properties
		UserDetails alex = User.withUsername("alex").password("{noop}123456").roles("teacher").build();
		UserDetails duc = User.withUsername("duc").password("{noop}123456").roles("manager").build();
		UserDetails moi = User.withUsername("moi").password("{noop}123456").roles("admin").build();
		return new InMemoryUserDetailsManager(alex, duc, moi);
	}
}
