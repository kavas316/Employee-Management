package com.project.employeeManagement.service;

import com.project.employeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    Employee getEmployeeById(long id);

}
