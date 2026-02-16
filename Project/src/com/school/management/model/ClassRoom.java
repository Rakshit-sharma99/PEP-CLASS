package com.school.management.model;

/**
 * ClassRoom Model
 * Represents a class/section in the school.
 */
public class ClassRoom {
    private int id;
    private String className;
    private String section;

    public ClassRoom() {
    }

    public ClassRoom(int id, String className, String section) {
        this.id = id;
        this.className = className;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return className + " - " + section;
    }
}
