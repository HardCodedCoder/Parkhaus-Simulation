package org.lecture;

import org.lecture.interfaces.IOHandler;
import org.lecture.interfaces.Service;
import org.lecture.utilities.CarGenerator;
import org.lecture.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class SimulationService implements Service {

    /**
     * Holds the IO handler managing the user interaction (input and output).
     * Static initialization of the IO handler as the UI should only be initialized once.
     */
    private static IOHandler ioHandler;

    /**
     * Holds the application's settings
     */
    private Settings settings;

    /**
     * Holds the history of all cars that have been parked in the parking lot.
     */
    private ParkingGarage parkingGarage;

    /**
     * Initializes a new instance of the ApplicationService class.
     * @param ioHandler The IO handler managing the user interaction (input and output).
     */
    public SimulationService(IOHandler ioHandler) {
        this.settings = Constants.DEFAULT_SETTINGS;
        this.parkingGarage = new ParkingGarage(ioHandler, this.settings.numberOfParkingLots());
    }

    /**
     * Sets the IO handler for the application.
     *
     * @param ioHandlerToSet the IO handler to set
     * @throws IllegalArgumentException if the IO handler is null
     */
    public static void setIOHandler(IOHandler ioHandlerToSet) throws IllegalArgumentException {
        if (ioHandlerToSet == null)
            throw new IllegalArgumentException("ioHandler cannot be null.");
        ioHandler = ioHandlerToSet;
    }

    /**
     * Returns the IO handler for the application.
     * @return the IO handler for the application.
     */
    public static IOHandler getIOHandler() {
        return ioHandler;
    }

    /**
     * Starts up the service main loop.
     */
    @Override
    public void run() {
        this.ioHandler.println();
        
        List<String> options = this.constructMenuPoints();
        boolean exit = false;
        
        while (!exit) {
           int choice = this.ioHandler.drawMenu(options);
           
           switch (choice) {
               case 1 -> this.runSimulation();
               case 2 -> this.printHistory();
               case 3 -> this.modifySettings();
               case 4 -> exit = true;
           }
        }

        this.shutdown();
    }

    /**
     * Shuts down the service main loop.
     */
    @Override
    public void shutdown() {
        this.ioHandler.println("Goodbye! Shutting down...");
    }

    /**
     * Runs the simulation.
     */
    private void runSimulation() {
        if (this.settings.overrideHistory())
            this.parkingGarage.clearHistory();

        List<Car> cars = CarGenerator.generateCars(this.settings.carsToGenerate(), parkingGarage);
        List<Thread> carThreads = new ArrayList<>();

        /** Start the cars first so that they can start driving into the garage.
         *  Then add them to the thread pool.
         * */
        for (Car car : cars) {
            Thread thread = new Thread(car);
            thread.start();
            carThreads.add(thread);
        }

        /** Wait for all cars to leave the garage. */
        for (Thread thread : carThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Allows the user to modify the application's settings.
     */
    public void modifySettings() {
        this.settings = this.ioHandler.getSettingsFromUser();
    }

    /**
     * Prints the history of all cars that have been parked in the parking lot.
     */
    public void printHistory() {
        this.parkingGarage.getHistory().forEach(entry -> this.ioHandler.println(entry.toString()));
    }

    /**
     * Constructs the menu points the application service offers to the user.
     * @return
     */
    private List<String> constructMenuPoints() {
        return List.of(
                "Parkhaus Simulation Starten",
                "Gesamte Parkhaus-Historie ausgeben",
                "Einstellungen",
                "Applikation beenden"
        );
    }
}
