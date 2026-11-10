package com.example.directory.controller;

import com.example.directory.model.Employee;
import com.example.directory.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // Show the directory table (with optional search)
    @GetMapping({"/", "/employees"})
    public String showEmployees(@RequestParam(required = false) String search, Model model) {
        List<Employee> employees = employeeService.searchEmployees(search);

        model.addAttribute("employees", employees);
        model.addAttribute("search", search);
        model.addAttribute("total", employees.size());

        return "employees"; // -> templates/employees.html
    }

    // Show an empty form to add a new employee
    @GetMapping("/employees/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("formTitle", "Add Employee");
        model.addAttribute("formAction", "/employees/add");
        return "employee-form"; // -> templates/employee-form.html
    }

    // Save the new employee, then go back to the table
    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    // Show the form filled with an employee's current details
    @GetMapping("/employees/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/employees";
        }
        model.addAttribute("employee", employee);
        model.addAttribute("formTitle", "Edit Employee");
        model.addAttribute("formAction", "/employees/edit/" + id);
        return "employee-form";
    }

    // Save the edited details, then go back to the table
    @PostMapping("/employees/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, @ModelAttribute Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    // Delete an employee, then go back to the table
    @PostMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
