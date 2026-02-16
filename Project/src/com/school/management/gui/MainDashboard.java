package com.school.management.gui;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {

    public MainDashboard(String role) {
        setTitle("School Management System - Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Add modules based on role (for now assume ADMIN has access to everything)
        if ("ADMIN".equalsIgnoreCase(role)) {
            tabbedPane.addTab("Students", new StudentPanel());
            tabbedPane.addTab("Teachers", new TeacherPanel());
            tabbedPane.addTab("Classes", new ClassPanel());
            tabbedPane.addTab("Attendance", new AttendancePanel());
        }

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(new JLabel("Role: " + role));
        topPanel.add(logoutButton);

        add(topPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
