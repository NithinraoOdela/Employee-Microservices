package com.example.employee_service_registery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmployeeServiceRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceRegisteryApplication.class, args);
	}

}
