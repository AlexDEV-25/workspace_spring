package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurity {
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.setUsersByUsernameQuery("select id, pw, active from accounts where id=?");
		userDetailsManager.setAuthoritiesByUsernameQuery("select id, role from roles where id=?");
		return userDetailsManager;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer //
				.requestMatchers("/public").permitAll()// ai cung lam duoc
				.requestMatchers("/admin/**").hasRole("ADMIN")// admin ms vao dc
				.requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")// admin va manager cung vao dc
				.requestMatchers("/teacher/**").hasAnyRole("ADMIN", "MANAGER", "TEACHER")// ai cung vao duoc
				.anyRequest().permitAll())
				// anyRequest().authenticated())//bat ki ai cung lam duoc
				.formLogin(// login
						form -> form.loginPage("/showLoginPage")// phai viet
								.loginProcessingUrl("/authenticateTheUser")// co san
								.permitAll())// cho phep ngay ca khi ko dang nhap
				.logout(// logout
						logout -> logout.permitAll())// cho phep ngay ca khi ko dang nhap
				.exceptionHandling(// exception
						configurer -> configurer.accessDeniedPage("/showPage403"))

		;

		return http.build();

	}

}
