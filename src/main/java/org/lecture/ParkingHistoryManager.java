package org.lecture;

import org.lecture.interfaces.IOHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class manages the history of all cars that have been parked in the parking lot.
 */
public class ParkingHistoryManager {

    /**
     * Holds the IO handler managing the user interaction (input and output).
     */
    private IOHandler ioHandler;

    /**
     * Holds the history of all cars that have been parked in the parking lot.
     */
    private List<HistoryEntry> entries = Collections.synchronizedList(new ArrayList<>());

    /**
     * Initializes a new instance of the ParkingHistoryManager class.
     * @param ioHandler The IO handler managing the user interaction (input and output).
     */
    public ParkingHistoryManager(IOHandler ioHandler) {
        if (ioHandler == null)
            throw new IllegalArgumentException("ioHandler cannot be null.");
        this.ioHandler = ioHandler;
    }

    /**
     * Adds a new entry to the history.
     * @param entry - The entry to add.
     */
    public synchronized void addEntry(HistoryEntry entry) {
        this.entries.add(entry);
        this.ioHandler.println(entry.toString());
    }

    /**
     * Clears the history of all entries.
     */
    public void clearHistory() {
        this.entries.clear();
    }

    /**
     * Returns the history of all cars that have been parked in the parking lot.
     * @return The history of all cars as a deep copy that have been parked in the parking lot.
     */
    public List<HistoryEntry> getHistory() {
        return new ArrayList<>(this.entries);
    }
}
