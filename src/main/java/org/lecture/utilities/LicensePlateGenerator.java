package org.lecture.utilities;

import java.util.Random;

/**
 * Helper class for generating license plates.
 */
public class LicensePlateGenerator {
    /**
     * Generates a random license plate in the format: <district> - <number><letter1><letter2>
     *     NOTE: The number consists of 3 digits.
     * @return The generated license plate.
     */
    public static String generateLicensePlate() {
        final String[] districtCodes = {"W", "WN", "ND", "OW", "GS", "JE", "MA", "OP", "G", "HB", "HF"};

        Random random = new Random();

        String district = districtCodes[random.nextInt(districtCodes.length)];

        int number = random.nextInt(100, 1000);

        final int numberOfLetters = 26;
        char letter1 = (char) ('A' + random.nextInt(numberOfLetters));
        char letter2 = (char) ('A' + random.nextInt(numberOfLetters));

        return String.format("%s - %03d%c%c", district, number, letter1, letter2);
    }
}
