package org.andrew;

import java.util.ArrayList;

public class Course {
    private String courseId;                 // C-departmentId-##
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    private static int nextId = 1;

    /**
     * checks if the sum of weights of all assignments of that course equals to 100%.
     * @return true (it does add up to 100%), false (it doesn't)
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment a : assignments) {
            sum += a.getWeight();
        }
        return sum == 100;
    }

    /**
     * adds a student to the student list of the course,
     * also add a new null element to each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student the student input
     * @return the list of courses with new student and both assignment and finalScores will have a new element
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student))
            return false;

        registeredStudents.add(student);

        // add null score to each assignment
        for (Assignment a : assignments) {
            a.addScorePlaceholder();
        }
        return true;
    }

}
