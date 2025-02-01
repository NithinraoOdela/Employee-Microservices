package com.company.employees.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employees.dto.EmployeesDto;
import com.company.employees.service.EmployeesService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;

@RestController
@RequestMapping("employees")
public class EmployeesController {

	Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	@Autowired
	public EmployeesService employeeService;

	@PostMapping
	public ResponseEntity<EmployeesDto> createEmployee(@Valid @RequestBody EmployeesDto employeesDto) {
		return employeeService.createEmployee(employeesDto);
	}

	@GetMapping
	public ResponseEntity<List<EmployeesDto>> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("{id}")
//	@Retry(name = "ratingHotelRetry", fallbackMethod = "projectFallback")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "projectFallback")
	@CircuitBreaker(name = "ProjectCircuit", fallbackMethod = "projectFallback")
	public ResponseEntity<EmployeesDto> getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployees(id);
	}

	public ResponseEntity<EmployeesDto> projectFallback(Integer id, Exception ex) {
		logger.info("fallback is executed because service is down: ", ex.getMessage());
		EmployeesDto employeesDto = EmployeesDto.builder().department("dummy").build();
		return ResponseEntity.ok(employeesDto);
	}

}
