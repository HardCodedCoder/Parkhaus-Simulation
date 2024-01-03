package org.lecture.interfaces;

import org.lecture.Settings;

import java.util.List;

public interface IOHandler {
    /**
     * Draws the menu to the user interface.
     * @return The menu point the user wants to enter.
     */
    int drawMenu(List<String> options);

    /**
     * Prints a line to the user interface.
     * @param message The message to print
     */
    void println(String message);

    /**
     * Prints an empty line to the user interface.
     */
    void println();

    /**
     * Prints an error message to the user interface.
     * @param message The message to print
     */
    void printErrorMessage(String message);

    /**
     * Gets the settings from the user.
     * @return An instance of the Settings class containing the user's settings.
     */
    Settings getSettingsFromUser();
}
