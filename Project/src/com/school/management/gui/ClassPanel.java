package com.school.management.gui;

import com.school.management.dao.ClassDAO;
import com.school.management.model.ClassRoom;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ClassPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private ClassDAO classDAO;

    private JTextField classNameField, sectionField;

    public ClassPanel() {
        setLayout(new BorderLayout());
        classDAO = new ClassDAO();

        // --- Form ---
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Class"));

        formPanel.add(new JLabel("Class Name:"));
        classNameField = new JTextField(10);
        formPanel.add(classNameField);

        formPanel.add(new JLabel("Section:"));
        sectionField = new JTextField(10);
        formPanel.add(sectionField);

        JButton addButton = new JButton("Add Class");
        addButton.addActionListener(e -> addClass());
        formPanel.add(addButton);

        // --- Table ---
        tableModel = new DefaultTableModel(new String[] { "ID", "Class Name", "Section" }, 0);
        table = new JTable(tableModel);

        loadClasses();

        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Context Menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete Selected");
        deleteItem.addActionListener(e -> deleteClass());
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
    }

    private void loadClasses() {
        tableModel.setRowCount(0);
        List<ClassRoom> classes = classDAO.getAllClasses();
        for (ClassRoom c : classes) {
            tableModel.addRow(new Object[] { c.getId(), c.getClassName(), c.getSection() });
        }
    }

    private void addClass() {
        String name = classNameField.getText();
        String sec = sectionField.getText();

        if (name.isEmpty() || sec.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        ClassRoom c = new ClassRoom();
        c.setClassName(name);
        c.setSection(sec);

        classDAO.addClass(c);
        loadClasses();
        classNameField.setText("");
        sectionField.setText("");
    }

    private void deleteClass() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Deleting a class will remove associated students (or set their class to null). Continue?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                classDAO.deleteClass(id);
                loadClasses();
            }
        }
    }
}
