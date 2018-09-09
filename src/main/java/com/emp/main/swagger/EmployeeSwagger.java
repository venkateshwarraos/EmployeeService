package com.emp.main.swagger;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class EmployeeSwagger {
	
	public Docket employeeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.emp.main"))
				.paths(PathSelectors.any())
				.build().apiInfo(metaData());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo metaData()  {
		ApiInfo apiInfo = new ApiInfo("EmployeeService" , "This service used to manage employee details", "1.0" , "http://localhost:8090/emp/employees", "venkyrao1986@gmail.com", "", "");
		return apiInfo;
	}

}
