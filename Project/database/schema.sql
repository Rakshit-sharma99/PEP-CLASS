-- Database Creation
CREATE DATABASE IF NOT EXISTS school_management_db;
USE school_management_db;

-- Users Table (For Admin Login)
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- In a real app, hash this!
    role VARCHAR(20) DEFAULT 'ADMIN'
);

-- Insert Default Admin (Username: admin, Password: admin123)
INSERT IGNORE INTO users (username, password, role) VALUES ('admin', 'admin123', 'ADMIN');

-- Classes/Sections Table
CREATE TABLE IF NOT EXISTS classes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(20) NOT NULL,
    section VARCHAR(10) NOT NULL,
    UNIQUE(class_name, section)
);

-- Teachers Table
CREATE TABLE IF NOT EXISTS teachers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    subject VARCHAR(50),
    phone VARCHAR(15),
    hire_date DATE
);

-- Students Table
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE,
    gender VARCHAR(10),
    email VARCHAR(100),
    phone VARCHAR(15),
    address TEXT,
    class_id INT,
    FOREIGN KEY (class_id) REFERENCES classes(id) ON DELETE SET NULL
);

-- Attendance Table
CREATE TABLE IF NOT EXISTS attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(10) NOT NULL, -- 'Present', 'Absent', 'Late'
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);

-- Sample Data
INSERT INTO classes (class_name, section) VALUES 
('10', 'A'), ('10', 'B'), ('11', 'Science'), ('12', 'Commerce');

INSERT INTO teachers (first_name, last_name, email, subject, phone, hire_date) VALUES 
('Alice', 'Smith', 'alice@school.com', 'Mathematics', '1234567890', '2022-01-15'),
('Bob', 'Johnson', 'bob@school.com', 'Physics', '0987654321', '2021-08-01');

INSERT INTO students (first_name, last_name, dob, gender, email, phone, address, class_id) VALUES 
('John', 'Doe', '2005-05-15', 'Male', 'john@student.com', '1112223333', '123 Main St', 1),
('Jane', 'Roe', '2006-03-10', 'Female', 'jane@student.com', '4445556666', '456 Oak Ave', 2);
