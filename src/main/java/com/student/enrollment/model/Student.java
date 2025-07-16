package com.student.enrollment.model;


public class Student {
	private int id;
    private String name;
    private String email;

    // Constructor
    public Student(int id,String name, String email) {
    	this.id=id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getid() { return id;}
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Setters (optional if not needed)
    public void setId(int id) { this.id=id;}
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
