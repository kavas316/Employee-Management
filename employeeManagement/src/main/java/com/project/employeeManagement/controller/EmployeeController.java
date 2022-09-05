package com.project.employeeManagement.controller;


import com.project.employeeManagement.model.Employee;
import com.project.employeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployee" +
                "s",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/new_employee")
    public String newEmployeeForm(Model model){
        // Create Model for form data
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
        // Save Employee from form to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id")long id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value="id")long id){
        this.employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
