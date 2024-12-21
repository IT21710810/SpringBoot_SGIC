package org.example.samuelITMaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
//@ComponentScan(basePackages = "org.example.samuelITMaven.util.mapper.EmployeeMapper")
//@ComponentScan(basePackages = "org.example.samuelITMaven.service.DesignationService")

public class SamuelItMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamuelItMavenApplication.class, args);
	}

}
