package org.andrew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
public class Student {
    @Setter private String studentId;
    private String studentName;
    @Setter private Gender gender;
    @Setter private Address address;
    @Setter private Department department;
    @Setter private ArrayList<Course> registeredCourses;

    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender,
                   Address address, Department department) {

        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();

        this.studentId = "S" + String.format("%06d", nextId++);
    }

    /**
     * Registers a course, this method (1) adds the course
     * to the student's registeredCourses list, (2) adds the student
     * to the course's registeredStudents list, (3) appends a null for the scores
     * of each assignment of the course.
     * If the course is already registered (exists in the student's registeredCourses list),
     * directly returns false without adding anything.
     * @param course the course input
     * @return adds the course in the student's registeredCourses list, in course's registeredStudents list
     * and a null for the scores of each assignment of the course
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course))
            return false;

        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

    /**
     * Drops a course, remove the course from the student's registeredCourses list,
     * and remove the student from the course's registeredStudents list.
     * If the course is not registered yet (not in the student's registeredCourses list),
     * directly returns false without removing anything.
     * @param course the course input
     * @return remove the course from the student's registeredCourses list,
     * and remove the student from the course's registeredStudents list.
     * If the course is not registered yet (not in the student's registeredCourses list),
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course))
            return false;

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    /**
     * converts a student to a simple string with only the studentId,
     * the studentName, and departmentName.
     * @return simplified string
     */
    public String toSimplifiedString() {
        return studentId + " - " + studentName + " (" +
                department.getDepartmentName() + ")";
    }

    /**
     * converts a student to a string that contains the studentId, the studentName,
     * the gender, the address and the department,
     * and the registeredCourses (only the courseId, the courseName, and the departmentName)
     * @return studentId, the studentName, the gender, the address and the department,
     *  and the registeredCourses (only the courseId, the courseName, and the departmentName) converted
     */
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

    /**
     * sets student name
     * @param studentName the student name input
     */
    public void setStudentName(String studentName) {
        this.studentName = Util.toTitleCase(studentName);
    }
}
