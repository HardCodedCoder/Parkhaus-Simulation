package org.lecture;

/**
 * Represents an entry in the parking lot's history.
 * @param timeStamp The time stamp of the entry.
 * @param licensePlate The license plate of the car the entry belongs to.
 * @param action The action taken by the car.
 */
public record HistoryEntry(String timeStamp, String licensePlate, String action) {

    /**
     * Overrides the toString method of object class.
     * @return A string representation of the history entry.
     */
    @Override
    public String toString() {
        return String.format("[%s]: %s %s", timeStamp, licensePlate, action);
    }
}
