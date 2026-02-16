package com.school.management.dao;

import com.school.management.config.DBConnection;
import com.school.management.model.Attendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public void markAttendance(Attendance attendance) {
        String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, attendance.getStudentId());
            stmt.setDate(2, attendance.getDate());
            stmt.setString(3, attendance.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Attendance> getAttendanceByDate(Date date) {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT a.*, s.first_name, s.last_name FROM attendance a " +
                "JOIN students s ON a.student_id = s.id " +
                "WHERE a.date = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Attendance a = new Attendance();
                a.setId(rs.getInt("id"));
                a.setStudentId(rs.getInt("student_id"));
                a.setDate(rs.getDate("date"));
                a.setStatus(rs.getString("status"));
                a.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name"));

                attendanceList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
}
