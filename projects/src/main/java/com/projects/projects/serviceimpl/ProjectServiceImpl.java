package com.projects.projects.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.projects.projects.dto.ProjectDto;
import com.projects.projects.entity.ProjectEntity;
import com.projects.projects.repository.ProjectRepository;
import com.projects.projects.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<List<ProjectDto>> getProjectDetails() {

		return ResponseEntity.ok(projectRepository.findAll().stream()
				.map(project -> modelMapper.map(project, ProjectDto.class)).toList());
	}

	@Override
	public ResponseEntity<ProjectDto> getProjectDetailById(Integer id) {
		return ResponseEntity.ok(modelMapper.map(
				projectRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Project not found" + id)),
				ProjectDto.class));
	}

	@Override
	public ResponseEntity<ProjectDto> addProjectDetails(ProjectDto projectDto) {

		return ResponseEntity.ok(modelMapper
				.map(projectRepository.save(modelMapper.map(projectDto, ProjectEntity.class)), ProjectDto.class));
	}

	@Override
	public ResponseEntity<List<ProjectDto>> getProjectDetailByEmployeeId(Integer empId) {
		return ResponseEntity.ok(projectRepository.findByEmpId(empId).stream()
				.map(project -> modelMapper.map(project, ProjectDto.class)).toList());
	}

}
