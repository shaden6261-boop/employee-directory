package com.example.directory.service;

import com.example.directory.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer: the part that holds and returns employee records.
// (A real company would read these from a database; here we keep a simple list.)
@Service
public class EmployeeService {

    private final List<Employee> employees = List.of(
        new Employee(1, "Sara Alharbi",    "HR Manager",          "Human Resources", "sara@company.com",    "0501111111"),
        new Employee(2, "Ahmed Alqahtani", "Software Engineer",   "IT",              "ahmed@company.com",   "0502222222"),
        new Employee(3, "Noura Alotaibi",  "Accountant",          "Finance",         "noura@company.com",   "0503333333"),
        new Employee(4, "Khalid Alshehri", "Network Admin",       "IT",              "khalid@company.com",  "0504444444"),
        new Employee(5, "Reem Aldosari",   "Marketing Specialist","Marketing",       "reem@company.com",    "0505555555"),
        new Employee(6, "Faisal Almutairi","Sales Lead",          "Sales",           "faisal@company.com",  "0506666666")
    );

    // Returns all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Returns employees whose name or department contains the search word
    public List<Employee> searchEmployees(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return employees;
        }
        String k = keyword.toLowerCase();
        return employees.stream()
                .filter(e -> e.getName().toLowerCase().contains(k)
                          || e.getDepartment().toLowerCase().contains(k))
                .toList();
    }
}
