package com.student.enrollment.model;

public class Person {
    protected String name;
    protected String email;

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}