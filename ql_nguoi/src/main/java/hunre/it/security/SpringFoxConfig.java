package hunre.it.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) // Chỉ định dùng Swagger 2
				.select().apis(RequestHandlerSelectors.any()) // Quét tất cả các API
				.paths(PathSelectors.ant("/persons")) // Lấy tất cả các đường dẫn /persons
				.build();
	}
}