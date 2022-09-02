package com.project.employeeManagement.controller;


import com.project.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/home")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployee" +
                "s",employeeService.getAllEmployees());
        return "index";
    }

}
