package com.school.management.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection
 * 
 * Manages the connection to the MySQL database.
 * Uses the JDBC driver to establish a connection.
 */
public class DBConnection {
    // Database URL, Username, and Password
    // NOTE: Change these if your configuration is different!
    private static final String URL = "jdbc:mysql://localhost:3306/school_management_db";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Default XAMPP password is empty

    /**
     * Establishes a connection to the database.
     * 
     * @return Connection object if successful, null otherwise.
     */
    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC Driver
            // Make sure mysql-connector-j-8.x.jar is in your classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Add the jar to your library path.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
    }
}
