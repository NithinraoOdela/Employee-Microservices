package com.projects.projects.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.projects.entity.ProjectEntity;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

	
	List<ProjectEntity> findByEmpId(Integer empId);

}
