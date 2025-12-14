import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {

    @Test
    public void testSingleWord() {
        assertEquals("Computer", Util.toTitleCase("computer"));
    }

    @Test
    public void testMultipleWords() {
        assertEquals(
                "Computer Science And Math",
                Util.toTitleCase("computer science and math")
        );
    }

    @Test
    public void testMixedCase() {
        assertEquals(
                "Yi Wang",
                Util.toTitleCase("yI wAnG")
        );
    }

    @Test
    public void testEmpty() {
        assertEquals("", Util.toTitleCase(""));
    }
}

