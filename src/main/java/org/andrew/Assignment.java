package org.andrew;

import java.util.ArrayList;
import java.util.Random;

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

    /**
     * Generates random score
     */
    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int r = rand.nextInt(11); // [0,10]
            int score;

            if (r == 0)
                score = rand.nextInt(61);              // [0,60]
            else if (r <= 2)
                score = 60 + rand.nextInt(11);         // [60,70]
            else if (r <= 4)
                score = 70 + rand.nextInt(11);         // [70,80]
            else if (r <= 8)
                score = 80 + rand.nextInt(11);         // [80,90]
            else
                score = 90 + rand.nextInt(11);         // [90,100]

            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getAssignmentId() { return assignmentId; }
    public String getAssignmentName() { return assignmentName; }
    public double getWeight() { return weight; }
    public ArrayList<Integer> getScores() { return scores; }
}
