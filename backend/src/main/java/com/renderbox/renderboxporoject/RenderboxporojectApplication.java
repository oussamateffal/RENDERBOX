package com.renderbox.renderboxporoject;

import com.renderbox.renderboxporoject.config.JwtRequestFilter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "RenderBox project API",
				version = "1.0.0",
				description = "Digital Agency Web Site",
				termsOfService = "runcodenow",
				contact = @Contact(
						name = "Achraf Aissy",
						email = "achrafaissy1@gmail.com"
				),
				license = @License(
						name = "license",
						url = "runcodenow"
				)
		)
)
public class RenderboxporojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenderboxporojectApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtRequestFilter jwtRequestFilter() {
		return new JwtRequestFilter();
	}
}
