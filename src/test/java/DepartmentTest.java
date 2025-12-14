import static org.junit.jupiter.api.Assertions.*;

import org.andrew.Department;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    public void testValidName() {
        assertTrue(Department.isDepartmentNameValid("Computer Science"));
    }

    @Test
    public void testInvalidCharacters() {
        assertFalse(Department.isDepartmentNameValid("CompSci123"));
    }

    @Test
    public void testEmptyName() {
        assertFalse(Department.isDepartmentNameValid(""));
    }
}
