package com.school.management.dao;

import com.school.management.config.DBConnection;
import com.school.management.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public void addTeacher(Teacher teacher) {
        String sql = "INSERT INTO teachers (first_name, last_name, email, subject, phone, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());
            stmt.setString(3, teacher.getEmail());
            stmt.setString(4, teacher.getSubject());
            stmt.setString(5, teacher.getPhone());
            stmt.setDate(6, teacher.getHireDate());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teachers";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("id"));
                t.setFirstName(rs.getString("first_name"));
                t.setLastName(rs.getString("last_name"));
                t.setEmail(rs.getString("email"));
                t.setSubject(rs.getString("subject"));
                t.setPhone(rs.getString("phone"));
                t.setHireDate(rs.getDate("hire_date"));

                teachers.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public void updateTeacher(Teacher teacher) {
        String sql = "UPDATE teachers SET first_name=?, last_name=?, email=?, subject=?, phone=?, hire_date=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());
            stmt.setString(3, teacher.getEmail());
            stmt.setString(4, teacher.getSubject());
            stmt.setString(5, teacher.getPhone());
            stmt.setDate(6, teacher.getHireDate());
            stmt.setInt(7, teacher.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(int id) {
        String sql = "DELETE FROM teachers WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
