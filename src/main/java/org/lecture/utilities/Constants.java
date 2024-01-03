package org.lecture.utilities;

import org.lecture.Settings;

/**
 * This class contains application constants that can be configured via the menu during runtime.
 */
public class Constants {

    /**
     * Holds the default settings for the application.
     */
    public static final Settings DEFAULT_SETTINGS =
            new Settings(100, 20, false);

    /**
     * The time in milliseconds that a car should wait in the garage before it is started.
     */
    public static final int CAR_ENTER_GARAGE_WAITING_TIME = 3000;

    /**
     * The time in milliseconds that a car should be parked in the parking lot.
     */
    public static final int PARKING_TIME = 60000;

}
