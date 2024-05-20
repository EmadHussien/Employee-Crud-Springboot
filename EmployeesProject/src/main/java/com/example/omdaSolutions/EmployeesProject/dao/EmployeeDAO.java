package com.example.omdaSolutions.EmployeesProject.dao;

import com.example.omdaSolutions.EmployeesProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
