package com.student.enrollment.dao;

//package dao;

import com.student.enrollment.model.Enrollment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public void enrollStudent(int studentId, int courseId) {
        String checkSql = "SELECT * FROM enrollments WHERE student_id = ? AND course_id = ?";
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, studentId);
            checkStmt.setInt(2, courseId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("This student is already enrolled in this course!");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, studentId);
                stmt.setInt(2, courseId);
                stmt.executeUpdate();
                System.out.println("Student enrolled successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollments";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Enrollment e = new Enrollment(
                    rs.getInt("id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id")
                );
                enrollments.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}
