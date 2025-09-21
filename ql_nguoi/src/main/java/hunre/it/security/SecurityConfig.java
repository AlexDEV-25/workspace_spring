package hunre.it.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// SecurityFilterChain là nơi định nghĩa quy tắc bảo mật cho các URL
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				// Khai báo các luật ủy quyền (authorization) cho những đường dẫn khác nhau
				.authorizeHttpRequests(auth -> auth
						// Mở quyền truy cập Swagger UI & OpenAPI JSON mà không cần đăng nhập
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

						// Các API /persons/** yêu cầu phải đăng nhập (bất kỳ user nào hợp lệ)
						// Nếu muốn ràng buộc theo quyền/role, thay bằng:
						// .requestMatchers("/persons/**").hasAuthority("DEMO_ROLE")
						// hoặc .hasRole("DEMO") nếu user dùng role "ROLE_DEMO"
						.requestMatchers("/persons/**").authenticated()

						// Những request còn lại cho phép truy cập tự do
						.anyRequest().permitAll())

				// Dùng HTTP Basic auth (Postman sẽ hỏi username/password)
				.httpBasic(Customizer.withDefaults())

				// Tắt CSRF cho REST API thuần (stateless, gọi bằng Postman/JS Client)
				// Nếu app có form POST (cookie-based session) thì KHÔNG tắt
				.csrf(csrf -> csrf.disable());

		// Trả về chuỗi filter đã cấu hình
		return http.build();
	}

	// Cấu hình người dùng demo trong bộ nhớ (InMemoryUserDetailsManager)
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		return new InMemoryUserDetailsManager(User.withUsername("demo")
				// Mật khẩu được mã hóa bằng BCrypt
				.password(encoder.encode("demo"))
				// Cấp 1 quyền (authority). Nếu muốn dùng hasRole("DEMO"), thì thay bằng
				// roles("DEMO")
				// Nếu hasRole("DEMO") thì sẽ ánh xạ thành authority "ROLE_DEMO"
				.authorities("DEMO_ROLE").build());
	}

	// PasswordEncoder sử dụng thuật toán BCrypt (khuyến nghị)
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
