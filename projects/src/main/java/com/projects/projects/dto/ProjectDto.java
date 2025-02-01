package com.projects.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

	private Integer id;
	private String projectName;
	private String framework;
	private Integer empId;
}
