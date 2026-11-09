package com.example.directory.model;

// Model: describes what one employee record looks like.
public class Employee {

    private int id;
    private String name;
    private String jobTitle;
    private String department;
    private String email;
    private String phone;

    public Employee(int id, String name, String jobTitle, String department, String email, String phone) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getJobTitle() { return jobTitle; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
