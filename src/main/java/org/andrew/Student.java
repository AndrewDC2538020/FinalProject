package org.andrew;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;                  // S###### (auto)
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;

    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender,
                   Address address, Department department) {

        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();

        // Auto-generate ID: S000001, S000002, ...
        this.studentId = "S" + String.format("%06d", nextId++);
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course))
            return false;

        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

}
