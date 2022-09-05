package com.project.employeeManagement.service;

import com.project.employeeManagement.model.Employee;
import com.project.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }
    public void deleteEmployee(Employee employee){
        this.employeeRepository.delete(employee);
    }

    public Employee getEmployeeById(long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else {
            throw new RuntimeException("Employee Not Found");
        }
        return employee;
    }


}
