import org.junit.jupiter.api.Test;
import org.lecture.Car;
import org.lecture.ParkingGarage;
import org.lecture.utilities.CarGenerator;
import org.lecture.view.ConsoleIOHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarGeneratorTest {

    @Test
    public void testGeneratedCarCount() {
        ConsoleIOHandler consoleIOHandler = new ConsoleIOHandler();
        ParkingGarage parkingGarage = new ParkingGarage(consoleIOHandler, 100);
        int carsToGenerate = 10;
        List<Car> generatedCars = CarGenerator.generateCars(carsToGenerate, parkingGarage);

        assertEquals(carsToGenerate, generatedCars.size(), "The generated car list size should match the requested number.");
    }

    @Test
    public void testGenerateZeroCars() {
        ConsoleIOHandler consoleIOHandler = new ConsoleIOHandler();
        ParkingGarage parkingGarage = new ParkingGarage(consoleIOHandler, 100);
        List<Car> generatedCars = CarGenerator.generateCars(0, parkingGarage);
        assertTrue(generatedCars.isEmpty(), "List should be empty when generating zero cars.");
    }

    @Test
    public void testGenerateNegativeNumbersOfCars() {
        ConsoleIOHandler consoleIOHandler = new ConsoleIOHandler();
        ParkingGarage parkingGarage = new ParkingGarage(consoleIOHandler, 100);
        int negativeNumber = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            CarGenerator.generateCars(negativeNumber, parkingGarage);
        }, "Method should throw IllegalArgumentException when a negative number of cars is requested.");
    }
}
