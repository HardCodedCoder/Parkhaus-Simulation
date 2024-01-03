package org.lecture;

/**
 * Represents the settings of the application.
 * @param carsToGenerate The number of cars to generate.
 * @param numberOfParkingLots The number of parking lots the parking garage should offer.
 * @param overrideHistory Each simulation overrides the previous simulation's history.
 */
public record Settings(int carsToGenerate, int numberOfParkingLots, boolean overrideHistory) {

}
