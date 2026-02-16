package com.school.management.model;

import java.sql.Date;

/**
 * Teacher Model
 * Represents a teacher entity.
 */
public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private String phone;
    private Date hireDate;

    // Constructors
    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, String email, String subject, String phone,
            Date hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subject = subject;
        this.phone = phone;
        this.hireDate = hireDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
