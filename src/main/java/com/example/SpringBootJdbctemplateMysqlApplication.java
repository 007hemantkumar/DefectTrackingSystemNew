package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
//@EnableSwagger2
//@EnableWebMvc
public class SpringBootJdbctemplateMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbctemplateMysqlApplication.class, args);
	}
	/*
	 * @Bean public Docket swaggerConfiguration() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select() .paths(PathSelectors.any())
	 * .apis(RequestHandlerSelectors.basePackage("com.example")) .build(); }
	 */
}
