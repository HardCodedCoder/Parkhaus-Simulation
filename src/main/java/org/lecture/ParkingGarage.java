package org.lecture;

import org.lecture.interfaces.IOHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * This class represents a parking garage. It manages the parking spots and records the parking history.
 */
public class ParkingGarage {
    /**
     * Used to control the number of spots in the parking garage.
     */
    private Semaphore spots;

    /**
     * Holds the IO handler managing the user interaction (input and output).
     */
    private IOHandler ioHandler;
    private ParkingHistoryManager parkingHistoryManager;

    /**
     * Holds the time stamp formatter for the parking events.
     */
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Initializes a new instance of the ParkingGarage class.
     * @param ioHandler The IO handler managing the user interaction (input and output).
     * @param capacity The number of spots in the parking garage.
     * @throws IllegalArgumentException Thrown if ioHandler is null.
     */
    public ParkingGarage(IOHandler ioHandler, int capacity) throws IllegalArgumentException {
        if (ioHandler == null)
            throw new IllegalArgumentException("ioHandler cannot be null.");
        this.ioHandler = ioHandler;
        this.spots = new Semaphore(capacity);
        this.parkingHistoryManager = new ParkingHistoryManager(ioHandler);
    }

    /**
     * Parks a car in the parking garage
     * @param car The car to park
     */
    public void enterGarage(Car car) {
        String timeStamp = dateTimeFormatter.format(LocalDateTime.now());
        this.parkingHistoryManager.addEntry(new HistoryEntry(timeStamp, car.getLicensePlate(), "möchte einfahren"));
        try {
            this.spots.acquire();
        } catch (InterruptedException e) {
            this.ioHandler.printErrorMessage(e.getMessage());
        }
        timeStamp = dateTimeFormatter.format(LocalDateTime.now());
        this.parkingHistoryManager.addEntry(new HistoryEntry(timeStamp, car.getLicensePlate(), "eingeparkt"));
    }

    /**
     * Releases a parking spot that was previously occupied by a car.
     *
     * @param car The car that has left the parking garage
     */
    public void leaveGarage(Car car) {
        String timeStamp = dateTimeFormatter.format(LocalDateTime.now());
        this.parkingHistoryManager.addEntry(new HistoryEntry(timeStamp, car.getLicensePlate(), "Verlässt das Parkhaus"));
        spots.release();
    }

    /**
     * Clears the history of the parking garage.
     */
    public void clearHistory() {
        this.parkingHistoryManager.clearHistory();
    }

    public List<HistoryEntry> getHistory() {
        return this.parkingHistoryManager.getHistory();
    }
}
