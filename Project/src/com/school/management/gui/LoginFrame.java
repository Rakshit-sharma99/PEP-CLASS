package com.school.management.gui;

import com.school.management.dao.UserDAO;
import com.school.management.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {
        setTitle("School Management System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginAction());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            UserDAO userDAO = new UserDAO();
            User user = userDAO.authenticate(username, password);

            if (user != null) {
                JOptionPane.showMessageDialog(LoginFrame.this, "Login Successful! Welcome " + user.getUsername());
                new MainDashboard(user.getRole());
                dispose(); // Close login window
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "Invalid Username or Password", "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
