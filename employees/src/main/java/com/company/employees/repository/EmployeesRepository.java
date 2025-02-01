package com.company.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.employees.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
