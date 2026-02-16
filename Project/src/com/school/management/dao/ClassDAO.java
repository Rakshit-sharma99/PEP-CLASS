package com.school.management.dao;

import com.school.management.config.DBConnection;
import com.school.management.model.ClassRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

    public List<ClassRoom> getAllClasses() {
        List<ClassRoom> classes = new ArrayList<>();
        String sql = "SELECT * FROM classes";
        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ClassRoom c = new ClassRoom();
                c.setId(rs.getInt("id"));
                c.setClassName(rs.getString("class_name"));
                c.setSection(rs.getString("section"));

                classes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    public void addClass(ClassRoom classRoom) {
        String sql = "INSERT INTO classes (class_name, section) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, classRoom.getClassName());
            stmt.setString(2, classRoom.getSection());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClass(int id) {
        String sql = "DELETE FROM classes WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
