package com.company;

import java.util.ArrayList;

public class Teacher extends Person {
    public Teacher(String name, String email){
        studentPreferences = new ArrayList<Student>();

        this.name = name;
        this.email = email;
    }

    public String toString() {
        return "Teacher{" +
                "project=" + project +
                ", studentPreferences=" + studentPreferences +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Project createProject(String name, int capacity){
        return (project = new Project(name, capacity));
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setPreferences(Student ... students){
        for(Student indexStudent : students){
            studentPreferences.add(indexStudent);
        }
    }

    private Project project;
    private ArrayList<Student> studentPreferences;
}
