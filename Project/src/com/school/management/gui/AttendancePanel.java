package com.school.management.gui;

import com.school.management.dao.AttendanceDAO;
import com.school.management.dao.StudentDAO;
import com.school.management.model.Attendance;
import com.school.management.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class AttendancePanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private AttendanceDAO attendanceDAO;
    private StudentDAO studentDAO;

    private JComboBox<Student> studentBox;
    private JComboBox<String> statusBox;
    private JTextField dateField;

    public AttendancePanel() {
        setLayout(new BorderLayout());
        attendanceDAO = new AttendanceDAO();
        studentDAO = new StudentDAO();

        // --- Form ---
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Mark Attendance"));

        formPanel.add(new JLabel("Student:"));
        studentBox = new JComboBox<>();
        loadStudents();
        formPanel.add(studentBox);

        formPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField(LocalDate.now().toString());
        formPanel.add(dateField);

        formPanel.add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[] { "Present", "Absent", "Late" });
        formPanel.add(statusBox);

        JButton markButton = new JButton("Mark Attendance");
        markButton.addActionListener(e -> markAttendance());
        formPanel.add(markButton);

        JButton viewButton = new JButton("View for Date");
        viewButton.addActionListener(e -> loadAttendance());
        formPanel.add(viewButton);

        // --- Table ---
        tableModel = new DefaultTableModel(new String[] { "ID", "Student Name", "Date", "Status" }, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadStudents() {
        studentBox.removeAllItems();
        List<Student> students = studentDAO.getAllStudents();
        for (Student s : students) {
            studentBox.addItem(s);
        }
    }

    private void markAttendance() {
        try {
            Student selectedStudent = (Student) studentBox.getSelectedItem();
            if (selectedStudent == null)
                return;

            Attendance a = new Attendance();
            a.setStudentId(selectedStudent.getId());
            a.setDate(Date.valueOf(dateField.getText()));
            a.setStatus((String) statusBox.getSelectedItem());

            attendanceDAO.markAttendance(a);
            JOptionPane.showMessageDialog(this, "Attendance Marked!");
            loadAttendance();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error marking attendance: " + e.getMessage());
        }
    }

    private void loadAttendance() {
        try {
            Date date = Date.valueOf(dateField.getText());
            List<Attendance> list = attendanceDAO.getAttendanceByDate(date);
            tableModel.setRowCount(0);
            for (Attendance a : list) {
                tableModel.addRow(new Object[] {
                        a.getId(),
                        a.getStudentName(),
                        a.getDate(),
                        a.getStatus()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Date");
        }
    }
}
