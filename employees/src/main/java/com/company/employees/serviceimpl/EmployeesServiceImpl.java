package com.company.employees.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.employees.dto.EmployeesDto;
import com.company.employees.entity.Employees;
import com.company.employees.exception.ResourceNotFoundExceptionHandler;
import com.company.employees.external.ProjectService;
import com.company.employees.repository.EmployeesRepository;
import com.company.employees.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	public EmployeesRepository employeesRepository;

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	private ProjectService projectService;

	@Override
	public ResponseEntity<EmployeesDto> createEmployee(EmployeesDto employeesDto) {
		return ResponseEntity.ok(modelMapper
				.map(employeesRepository.save(modelMapper.map(employeesDto, Employees.class)), EmployeesDto.class));
	}

	@Override
	public ResponseEntity<List<EmployeesDto>> getAllEmployees() {
		List<Employees> employeesList = employeesRepository.findAll();
		
		
		List<EmployeesDto> employeesDtolist = employeesList.stream()
				.map(employee -> modelMapper.map(employee, EmployeesDto.class)).toList();
		
		
		for(EmployeesDto employee : employeesDtolist)
		{
			employee.setProjects(projectService.getProjectDetailByEmployeeId(employee.getId()).getBody());
		}

		return ResponseEntity.ok(employeesDtolist);
	}

	@Override
	public ResponseEntity<EmployeesDto> getEmployees(Integer id) {
		EmployeesDto employee = modelMapper.map(
				employeesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptionHandler("not found")),
				EmployeesDto.class);

		employee.setProjects(projectService.getProjectDetailByEmployeeId(id).getBody());

		return ResponseEntity.ok(employee);
	}

}
