package com.student.enrollment.main;

//package main;

import com.student.enrollment.dao.StudentDAO;
import com.student.enrollment.dao.CourseDAO;
import com.student.enrollment.dao.EnrollmentDAO;
import com.student.enrollment.model.Student;
import com.student.enrollment.model.Course;
import com.student.enrollment.model.Enrollment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Enroll Student to Course");
            System.out.println("6. View All Enrollments");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    if(name.length()==0) {
                    	System.out.println("Please Enter a Valid name");
                    	name = scanner.nextLine();
                    }
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    if(!email.contains("@")){
                    	System.out.println("Please Enter a Valid Email");
                    	email = scanner.nextLine();
                    }
                    Student student = new Student(0,name, email);
                    studentDAO.addStudent(student);
                    break;
                case 2:
                    studentDAO.getAllStudents().forEach(s ->
                        System.out.println(s.getid() + " | " + s.getName() + " | " + s.getEmail())
                    );
                    break;

                case 3:
                    System.out.print("Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    Course course = new Course(0, courseName, desc);
                    courseDAO.addCourse(course);
                    break;

                case 4:
                    courseDAO.getAllCourses().forEach(c ->
                        System.out.println(c.getId() + ": " + c.getName() + " | " + c.getDescription())
                    );
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    enrollmentDAO.enrollStudent(studentId, courseId);
                    break;

                case 6:
                    enrollmentDAO.getAllEnrollments().forEach(e ->
                        System.out.println("Enrollment ID: " + e.getId() +
                            ", Student ID: " + e.getStudentId() +
                            ", Course ID: " + e.getCourseId())
                    );
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}