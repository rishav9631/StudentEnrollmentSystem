package com.student.enrollment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // MySQL DB credentials and URL
    private static final String URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12789862";
    private static final String USER = "sql12789862";
    private static final String PASSWORD = "FugGl4Gi5p";

    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        // Establish and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
