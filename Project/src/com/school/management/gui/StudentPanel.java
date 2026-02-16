package com.school.management.gui;

import com.school.management.dao.ClassDAO;
import com.school.management.dao.StudentDAO;
import com.school.management.model.ClassRoom;
import com.school.management.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.List;

public class StudentPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private StudentDAO studentDAO;
    private ClassDAO classDAO;

    // Form fields
    private JTextField firstNameField, lastNameField, dobField, emailField, phoneField, addressField;
    private JComboBox<String> genderBox;
    private JComboBox<ClassRoom> classBox; // Stores ClassRoom objects

    public StudentPanel() {
        setLayout(new BorderLayout());
        studentDAO = new StudentDAO();
        classDAO = new ClassDAO();

        // --- Form Panel ---
        JPanel formPanel = new JPanel(new GridLayout(9, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("DOB (YYYY-MM-DD):"));
        dobField = new JTextField();
        formPanel.add(dobField);

        formPanel.add(new JLabel("Gender:"));
        genderBox = new JComboBox<>(new String[] { "Male", "Female", "Other" });
        formPanel.add(genderBox);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        formPanel.add(addressField);

        formPanel.add(new JLabel("Class:"));
        classBox = new JComboBox<>();
        loadClasses();
        formPanel.add(classBox);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> addStudent());
        formPanel.add(addButton);

        JButton refreshButton = new JButton("Refresh List");
        refreshButton.addActionListener(e -> loadStudents());
        formPanel.add(refreshButton);

        // --- Table Panel ---
        tableModel = new DefaultTableModel(
                new String[] { "ID", "Name", "DOB", "Gender", "Email", "Phone", "Class", "Address" }, 0);
        table = new JTable(tableModel);
        loadStudents();

        JScrollPane scrollPane = new JScrollPane(table);

        // --- Layout ---
        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Context Menu for Delete
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete Selected");
        deleteItem.addActionListener(e -> deleteStudent());
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void loadClasses() {
        classBox.removeAllItems();
        List<ClassRoom> classes = classDAO.getAllClasses();
        for (ClassRoom c : classes) {
            classBox.addItem(c);
        }
    }

    private void loadStudents() {
        tableModel.setRowCount(0);
        List<Student> students = studentDAO.getAllStudents();
        for (Student s : students) {
            tableModel.addRow(new Object[] {
                    s.getId(),
                    s.getFirstName() + " " + s.getLastName(),
                    s.getDob(),
                    s.getGender(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getClassName(),
                    s.getAddress()
            });
        }
    }

    private void addStudent() {
        try {
            Student s = new Student();
            s.setFirstName(firstNameField.getText());
            s.setLastName(lastNameField.getText());
            s.setDob(Date.valueOf(dobField.getText())); // Basic validation
            s.setGender((String) genderBox.getSelectedItem());
            s.setEmail(emailField.getText());
            s.setPhone(phoneField.getText());
            s.setAddress(addressField.getText());

            ClassRoom selectedClass = (ClassRoom) classBox.getSelectedItem();
            if (selectedClass != null) {
                s.setClassId(selectedClass.getId());
            }

            studentDAO.addStudent(s);
            JOptionPane.showMessageDialog(this, "Student Added!");
            loadStudents();
            clearFields();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Invalid Date Format (YYYY-MM-DD)", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding student: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                studentDAO.deleteStudent(id);
                loadStudents();
            }
        }
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        dobField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
    }
}
