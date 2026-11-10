package com.example.directory.service;

import com.example.directory.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Service layer: holds the employee records and the operations on them
// (show, search, add, edit, delete). A real company would use a database.
@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>(List.of(
        new Employee(1, "Sara Alharbi",    "HR Manager",          "Human Resources", "sara@company.com",    "0501111111"),
        new Employee(2, "Ahmed Alqahtani", "Software Engineer",   "IT",              "ahmed@company.com",   "0502222222"),
        new Employee(3, "Noura Alotaibi",  "Accountant",          "Finance",         "noura@company.com",   "0503333333"),
        new Employee(4, "Khalid Alshehri", "Network Admin",       "IT",              "khalid@company.com",  "0504444444"),
        new Employee(5, "Reem Aldosari",   "Marketing Specialist","Marketing",       "reem@company.com",    "0505555555"),
        new Employee(6, "Faisal Almutairi","Sales Lead",          "Sales",           "faisal@company.com",  "0506666666")
    ));

    private int nextId = 7;

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

    // Finds one employee by ID (or null if not found)
    public Employee findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Adds a new employee with the next free ID
    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
    }

    // Updates an existing employee's details
    public void updateEmployee(int id, Employee updated) {
        Employee e = findById(id);
        if (e != null) {
            e.setName(updated.getName());
            e.setJobTitle(updated.getJobTitle());
            e.setDepartment(updated.getDepartment());
            e.setEmail(updated.getEmail());
            e.setPhone(updated.getPhone());
        }
    }

    // Deletes an employee by ID
    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }
}
