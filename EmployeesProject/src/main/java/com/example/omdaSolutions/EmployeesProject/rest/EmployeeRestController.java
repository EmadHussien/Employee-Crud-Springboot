package com.example.omdaSolutions.EmployeesProject.rest;

import com.example.omdaSolutions.EmployeesProject.dao.EmployeeDAO;
import com.example.omdaSolutions.EmployeesProject.entity.Employee;
import com.example.omdaSolutions.EmployeesProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController (EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee =  employeeService.findById(employeeId);
        if (theEmployee == null)
        {
            throw new RuntimeException("Employee id is not found - "+ employeeId);
        }
        return  theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        if(theEmployee.getId() == 0 )
            throw new RuntimeException("id cannot be null!");
        System.out.println("+++++++++++++++++this is the sent id+++++ "+ theEmployee.getId());
        Employee dbEmployee = employeeService.save(theEmployee);
        return  dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null)
        {
            throw  new RuntimeException("Employee is not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "deleted employee id - " + employeeId;
    }
}
