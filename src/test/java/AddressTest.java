import static org.junit.jupiter.api.Assertions.*;

import org.andrew.Address;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testValidPostalCode() {
        assertTrue(Address.isPostalCodeValid("H2X3Y4"));
    }

    @Test
    public void testInvalidLength() {
        assertFalse(Address.isPostalCodeValid("H2X3"));
    }

    @Test
    public void testInvalidFormat() {
        assertFalse(Address.isPostalCodeValid("123456"));
    }
}

