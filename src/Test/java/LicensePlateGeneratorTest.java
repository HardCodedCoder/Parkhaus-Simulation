import org.junit.jupiter.api.Test;
import org.lecture.utilities.LicensePlateGenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

/**
 * Test class for LicensePlateGenerator.
 */
public class LicensePlateGeneratorTest {

    @Test
    public void testLicensePlateFormat() {
        for(int i = 0; i < 100; i++) {
            String licensePlate = LicensePlateGenerator.generateLicensePlate();

            assertTrue(Pattern.matches("[A-Z]{1,3} - \\d{3}[A-Z]{2}", licensePlate),
                    "License plate should match the specified format. Found: " + licensePlate);
        }
    }

    @Test
    public void testLicensePlateUniqueness() {
        String licensePlate1 = LicensePlateGenerator.generateLicensePlate();
        String licensePlate2 = LicensePlateGenerator.generateLicensePlate();

        assertNotEquals(licensePlate1, licensePlate2, "Two generated license plates should be different");
    }
}
