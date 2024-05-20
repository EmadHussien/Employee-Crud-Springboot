package com.example.omdaSolutions.EmployeesProject.service;

import com.example.omdaSolutions.EmployeesProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
