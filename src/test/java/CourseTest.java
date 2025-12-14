import static org.junit.jupiter.api.Assertions.*;

import org.andrew.Course;
import org.andrew.Department;
import org.andrew.Student;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testAssignmentWeightValid() {
        Department d = new Department("Computer Science");
        Course c = new Course("Java Programming", 3, d);

        c.addAssignment("A1", 40, 100);
        c.addAssignment("A2", 60, 100);

        assertTrue(c.isAssignmentWeightValid());
    }

    @Test
    public void testCalcStudentAverage() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3, d);

        Student s = new Student(
                "john doe",
                Student.Gender.MALE,
                null,
                d
        );

        // IMPORTANT: add assignment FIRST
        c.addAssignment("Final", 100, 100);

        // THEN register student
        s.registerCourse(c);

        // manually set score (no randomness)
        c.getAssignments().get(0).getScores().set(0, 80);

        assertEquals(80, c.calcStudentAverage(0));
    }
}
