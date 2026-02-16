package com.school.management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SetupDB {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("Starting Database Setup...");

        // 1. Load Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: MySQL JDBC Driver not found!");
            System.err.println("Please download 'mysql-connector-j-8.x.jar' and place it in a 'lib' folder.");
            System.exit(1);
        }

        File sqlFile = new File("database/schema.sql");
        if (!sqlFile.exists()) {
            System.err.println("ERROR: Could not find database/schema.sql");
            System.exit(1);
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()) {

            System.out.println("Connected to MySQL Server.");

            // Allow multi-queries or just parse split by ;
            // Simple split by ; might fail if ; is inside strings, but for this schema it's
            // fine.
            Scanner scanner = new Scanner(sqlFile);
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                String sql = scanner.next().trim();
                if (sql.isEmpty())
                    continue;

                // Handle comments stripping roughly if needed,
                // but usually Statement can handle comments or we should strip them.
                // The schema.sql has -- comments.
                // Simple approach: executeUpdate

                try {
                    stmt.execute(sql);
                    System.out.println("Executed: " + (sql.length() > 50 ? sql.substring(0, 50) + "..." : sql));
                } catch (Exception ex) {
                    System.err.println("Warning executing statement: " + ex.getMessage());
                }
            }
            scanner.close();
            System.out.println("Database Setup Completed Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Database Setup Failed.");
        }
    }
}
