package com.school.management.model;

import java.sql.Date;

/**
 * Attendance Model
 * Represents attendance record for a student.
 */
public class Attendance {
    private int id;
    private int studentId;
    private Date date;
    private String status;
    private String studentName; // Helper for display

    public Attendance() {
    }

    public Attendance(int id, int studentId, Date date, String status) {
        this.id = id;
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
