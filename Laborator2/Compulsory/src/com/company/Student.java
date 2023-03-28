package com.company;

import java.util.ArrayList;

public class Student extends Person {
    public Student(String name, String email){
        projectPreferences = new ArrayList<Project>();

        this.name = name;
        this.email = email;
    }

    public String toString() {
        return "Student{" +
                "projectPreferences=" + projectPreferences +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setPreferences(Project ... projects){
        for(Project indexProject : projects){
            projectPreferences.add(indexProject);
        }
    }

    private ArrayList<Project> projectPreferences;
}
