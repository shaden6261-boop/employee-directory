package com.example.directory.controller;

import com.example.directory.model.Employee;
import com.example.directory.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// Controller: receives the browser request, asks the service for data,
// and sends that data to the Thymeleaf page.
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Opening http://localhost:8080/ (or /employees) shows the directory
    @GetMapping({"/", "/employees"})
    public String showEmployees(@RequestParam(required = false) String search, Model model) {
        List<Employee> employees = employeeService.searchEmployees(search);

        model.addAttribute("employees", employees);   // the list for the table
        model.addAttribute("search", search);         // keep the search word in the box
        model.addAttribute("total", employees.size()); // number of results

        return "employees"; // -> templates/employees.html
    }
}
