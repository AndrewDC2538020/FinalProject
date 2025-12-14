package org.andrew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
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

    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course))
            return false;

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    public String toSimplifiedString() {
        return studentId + " - " + studentName + " (" +
                department.getDepartmentName() + ")";
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}
