package com.example.directory.model;

// Model: describes what one employee record looks like.
public class Employee {

    private int id;
    private String name;
    private String jobTitle;
    private String department;
    private String email;
    private String phone;

    // Empty constructor: needed so Spring can fill the object from the form
    public Employee() {
    }

    public Employee(int id, String name, String jobTitle, String department, String email, String phone) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
