package org.lecture;

import org.lecture.interfaces.IOHandler;
import org.lecture.utilities.Constants;
import org.lecture.utilities.LicensePlateGenerator;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Car implements Runnable {
    private String licensePlate;
    private ParkingGarage garage;

    public Car(ParkingGarage parkingGarage) {
        this.licensePlate = generateLicensePlate();
        if (parkingGarage == null)
            throw new IllegalArgumentException("Parking garage cannot be null");
        this.garage = parkingGarage;
    }

    /**
     * Generates a random license plate via the LicensePlateGenerator class.
     * @return - license plate in the format of "A – 000AA"
     */
    private String generateLicensePlate() {
        return LicensePlateGenerator.generateLicensePlate();
    }

     /**
     * Returns the license plate of the car.
     *
     * @return the license plate of the car
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public void run() {
        try {
            /** Bevor ein Auto in das Parkhaus einfahren kann, muss es BIS ZU 3 Sekunden (0 bis 3000
             Millisekunden) warten. */
            Thread.sleep(new Random().nextInt(Constants.CAR_ENTER_GARAGE_WAITING_TIME));
            garage.enterGarage(this);
            Thread.sleep(Constants.PARKING_TIME);
            garage.leaveGarage(this);
        } catch (InterruptedException e) {
            SimulationService.getIOHandler().printErrorMessage(e.getMessage());
        }
    }
}
