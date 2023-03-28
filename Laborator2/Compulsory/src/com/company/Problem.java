package com.company;

import java.util.ArrayList;

public class Problem {
    public Problem(){
        studentList = new ArrayList<Student>();
        teacherList = new ArrayList<Teacher>();
    }

    public String toString() {
        return "Problem{" +
                "studentList=" + studentList +
                ", teacherList=" + teacherList +
                '}';
    }

    public void setStudents(Student ... students){
        for(Student indexStudent : students){
            studentList.add(indexStudent);
        }
    }

    public void setTeachers(Teacher ... teachers){
        for(Teacher indexTeacher : teachers){
            teacherList.add(indexTeacher);
        }
    }


    private ArrayList<Student> studentList;
    private ArrayList<Teacher> teacherList;
}
