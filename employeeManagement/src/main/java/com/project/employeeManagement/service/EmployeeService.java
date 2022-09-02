package com.project.employeeManagement.service;

import com.project.employeeManagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
}
