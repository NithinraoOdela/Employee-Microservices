package com.company.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	private Integer id;
	private String projectName;
	private String framework;
	private Integer empId;

}
