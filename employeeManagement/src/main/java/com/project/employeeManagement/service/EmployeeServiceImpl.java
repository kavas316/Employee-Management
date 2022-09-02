package com.project.employeeManagement.service;

import com.project.employeeManagement.model.Employee;
import com.project.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{


 private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
