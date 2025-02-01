package com.company.employees.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.employees.dto.Project;

@FeignClient(name = "PROJECTS")
public interface ProjectService {

	@GetMapping("project/empId/{empId}")
	public ResponseEntity<List<Project>> getProjectDetailByEmployeeId(@PathVariable Integer empId);

}
