package com.company.employees.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.employees.dto.EmployeesDto;

@Service
public interface EmployeesService {

	ResponseEntity<EmployeesDto> createEmployee(EmployeesDto employeesDto);

	ResponseEntity<List<EmployeesDto>> getAllEmployees();

	ResponseEntity<EmployeesDto> getEmployees(Integer id);

	
	
}
