package com.school.management.gui;

import com.school.management.dao.TeacherDAO;
import com.school.management.model.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.List;

public class TeacherPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private TeacherDAO teacherDAO;

    private JTextField firstNameField, lastNameField, emailField, subjectField, phoneField, hireDateField;

    public TeacherPanel() {
        setLayout(new BorderLayout());
        teacherDAO = new TeacherDAO();

        // --- Form Panel ---
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Teacher Details"));

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Subject:"));
        subjectField = new JTextField();
        formPanel.add(subjectField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Hire Date (YYYY-MM-DD):"));
        hireDateField = new JTextField();
        formPanel.add(hireDateField);

        JButton addButton = new JButton("Add Teacher");
        addButton.addActionListener(e -> addTeacher());
        formPanel.add(addButton);

        JButton refreshButton = new JButton("Refresh List");
        refreshButton.addActionListener(e -> loadTeachers());
        formPanel.add(refreshButton);

        // --- Table Panel ---
        tableModel = new DefaultTableModel(new String[] { "ID", "Name", "Email", "Subject", "Phone", "Hire Date" }, 0);
        table = new JTable(tableModel);
        loadTeachers();

        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Context Menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete Selected");
        deleteItem.addActionListener(e -> deleteTeacher());
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void loadTeachers() {
        tableModel.setRowCount(0);
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        for (Teacher t : teachers) {
            tableModel.addRow(new Object[] {
                    t.getId(),
                    t.getFirstName() + " " + t.getLastName(),
                    t.getEmail(),
                    t.getSubject(),
                    t.getPhone(),
                    t.getHireDate()
            });
        }
    }

    private void addTeacher() {
        try {
            Teacher t = new Teacher();
            t.setFirstName(firstNameField.getText());
            t.setLastName(lastNameField.getText());
            t.setEmail(emailField.getText());
            t.setSubject(subjectField.getText());
            t.setPhone(phoneField.getText());
            t.setHireDate(Date.valueOf(hireDateField.getText()));

            teacherDAO.addTeacher(t);
            JOptionPane.showMessageDialog(this, "Teacher Added!");
            loadTeachers();
            clearFields();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Invalid Date Format", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding teacher: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTeacher() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this teacher?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                teacherDAO.deleteTeacher(id);
                loadTeachers();
            }
        }
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        subjectField.setText("");
        phoneField.setText("");
        hireDateField.setText("");
    }
}
