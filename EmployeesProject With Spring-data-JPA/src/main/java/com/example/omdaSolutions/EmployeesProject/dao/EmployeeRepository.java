package com.example.omdaSolutions.EmployeesProject.dao;

import com.example.omdaSolutions.EmployeesProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>
{
}
