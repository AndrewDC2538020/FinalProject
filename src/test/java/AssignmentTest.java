import static org.junit.jupiter.api.Assertions.*;

import org.andrew.Assignment;
import org.junit.jupiter.api.Test;

public class AssignmentTest {

    @Test
    public void testAverageCalculation() {
        Assignment a = new Assignment("Midterm", 50);

        a.addScorePlaceholder();
        a.addScorePlaceholder();
        a.addScorePlaceholder();

        a.getScores().set(0, 80);
        a.getScores().set(1, 90);
        a.getScores().set(2, 100);

        assertEquals(90.0, a.calcAssignmentAvg());
    }

    @Test
    public void testAverageWithNulls() {
        Assignment a = new Assignment("Quiz", 10);
        a.addScorePlaceholder();
        a.getScores().set(0, null);

        assertEquals(0, a.calcAssignmentAvg());
    }
}

