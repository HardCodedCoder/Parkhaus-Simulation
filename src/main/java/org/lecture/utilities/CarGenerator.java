package org.lecture.utilities;

import org.lecture.Car;
import org.lecture.ParkingGarage;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a helper class for generation cars.
 */
public class CarGenerator {
    /**
     * Generates a list of cars.
     * @param carsToGenerate The number of cars to generate.
     * @param parkingGarage The parking garage to where the generated cars will be parked.
     * @return A list containing the generated cars.
     */
    public static List<Car> generateCars(int carsToGenerate, ParkingGarage parkingGarage) {
        List<Car> generatedCars = new ArrayList<>();
        for (int i = 0; i < carsToGenerate; i++) {
            generatedCars.add(new Car(parkingGarage));
        }

        return generatedCars;
    }
}
