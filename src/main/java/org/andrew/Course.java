package org.andrew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
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

        for (Assignment a : assignments) {
            a.addScorePlaceholder();
        }
        return true;
    }

    /**
     * calculates the weighted average score of a student.
     * @param index the index input
     * @return the average score of a student
     */
    public int calcStudentAverage(int index) {
        double total = 0;

        for (Assignment a : assignments) {
            Integer score = a.getScores().get(index);
            if (score != null) {
                total += score * a.getWeight() / 100;
            }
        }
        return (int) total;
    }

    /**
     * adds a new assignment to the course, always return true.
     * @param assignmentName the assignmentName input
     * @param weight the weight input
     * @param maxScore the maxScore input
     * @return true
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        assignments.add(new Assignment(assignmentName, weight));

        // add placeholder scores for existing students
        for (int i = 0; i < registeredStudents.size(); i++) {
            assignments.get(assignments.size() - 1).addScorePlaceholder();
        }
        return true;
    }

    /**
     * generates random scores for each assignment and student, and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment a : assignments) {
            a.generateRandomScore();
        }
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average.
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");

        for (Assignment a : assignments) {
            System.out.print(a.getAssignmentName() + "\t");
        }
        System.out.println("Final");

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.print(registeredStudents.get(i).getStudentName() + "\t");
            for (Assignment a : assignments) {
                System.out.print(a.getScores().get(i) + "\t");
            }
            System.out.println(calcStudentAverage(i));
        }

        System.out.print("Average\t");
        for (Assignment a : assignments) {
            System.out.print((int) a.calcAssignmentAvg() + "\t");
        }
        System.out.println();
    }

    /**
     * converts a course to a simple string with only the courseId, courseName, credits, and departmentName.
     * @return a simple string with only the courseId, courseName, credits, and departmentName
     */
    public String toSimplifiedString() {
        return courseId + " " + courseName + " " + credits + " " +
                department.getDepartmentName();
    }

    /**
     *  converts a course to a string that contains the courseId, the courseName,
     *  the credits, the departmentName the assignments,
     *  the registeredStudents (only the studentId, the studentName and the departmentName),
     *  and a line to show if the current isAssignmentWeightValid is valid or not.
     * @return a string that contains the courseId, the courseName,
     * the credits, the departmentName the assignments,
     * the registeredStudents (only the studentId, the studentName and the departmentName),
     * and a line to show if the current isAssignmentWeightValid is valid or not.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(courseId).append(", ")
                .append(courseName).append(", ")
                .append(credits).append(", ")
                .append(department.getDepartmentName()).append("\n");

        sb.append("Assignments: ").append(assignments).append("\n");
        sb.append("Students:\n");

        for (Student s : registeredStudents) {
            sb.append("  ")
                    .append(s.getStudentId()).append(" ")
                    .append(s.getStudentName()).append(" ")
                    .append(s.getDepartment().getDepartmentName())
                    .append("\n");
        }

        sb.append("Assignment weight valid: ")
                .append(isAssignmentWeightValid());

        return sb.toString();
    }
}
