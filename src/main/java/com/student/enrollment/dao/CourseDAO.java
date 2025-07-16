package com.student.enrollment.dao;

//package dao;

import com.student.enrollment.model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public void addCourse(Course course) {
        String sql = "INSERT INTO courses (name, description) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.executeUpdate();
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course c = new Course(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                );
                courses.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
