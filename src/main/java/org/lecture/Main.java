package org.lecture;

import org.lecture.interfaces.IOHandler;
import org.lecture.interfaces.Service;
import org.lecture.view.ConsoleIOHandler;

public class Main {

    public static void main(String[] args) {
        IOHandler ioHandler = new ConsoleIOHandler();
        try {
            SimulationService.setIOHandler(ioHandler);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Service applicationService = new SimulationService(ioHandler);
        applicationService.run();
    }
}

