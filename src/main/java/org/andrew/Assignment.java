package org.andrew;

import java.util.ArrayList;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int numberOfStudents) {
        this.assignmentId = "A" + nextId++;
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * calculates the average score for the assignment.
     * @return the average score
     */
    public double calcAssignmentAvg() {
        int sum = 0;
        int count = 0;

        for (Integer s : scores) {
            if (s != null) {
                sum += s;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }


}
