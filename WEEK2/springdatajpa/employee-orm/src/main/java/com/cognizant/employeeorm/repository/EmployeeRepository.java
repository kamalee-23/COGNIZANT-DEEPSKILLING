package com.cognizant.employeeorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employeeorm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}