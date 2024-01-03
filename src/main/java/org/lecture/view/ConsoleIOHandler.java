package org.lecture.view;

import org.lecture.Settings;
import org.lecture.enumerations.ForegroundColor;
import org.lecture.interfaces.IOHandler;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleIOHandler implements IOHandler {

    /**
     * Holds the ANSI_RESET constant to reset.
     * @Patrizia As the color is only relevant to the ConsoleIOHandler, it's better
     * to leave it where it is needed.
     */
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Holds the scanner to read from the user interface.
     */
    private Scanner scanner;

    /**
     * Initializes a new instance of the ConsoleIOHandler class.
     */
    public ConsoleIOHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a menu to the console and returns the choice of the user.
     * @param options The options of the menu.
     * @return The choice of the user.
     */
    @Override
    public int drawMenu(List<String> options) {
        AsciiArtHeader.printAsciiArtHeader();

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        int choice;
        while (true) {
            try {
                System.out.print("Bitte wählen Sie eine Option: ");
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= options.size()) {
                    break;
                } else {
                    System.out.println("Ungültige Option. Bitte geben Sie eine gültige Option ein.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            }
        }

        return choice;
    }

    /**
     * Prints a line to the user interface.
     *
     * @param message The message to print
     */
    @Override
    public void println(String message) {
        System.out.println(message);
    }

    /**
     * Prints an empty line to the user interface.
     */
    @Override
    public void println() {
        this.println("");
    }

    /**
     * Prints an error message to the user interface.
     *
     * @param message The message to print
     */
    @Override
    public void printErrorMessage(String message)
    {
        this.printColored("[ERROR]: ", ForegroundColor.RED);
        this.println(message);
    }

    /**
     * Gets the settings from the user.
     *
     * @return An instance of the Settings class containing the user's settings.
     */
    @Override
    public Settings getSettingsFromUser() {
        this.println("Die Einstellungen die zu treffen sind umfassen folgende Punkte:\n\n\t\t" +
                "o) Anzahl der Autos: Die Anzahl der Autos die für die Simulation genutzt werden sollen.\n\t\t" +
                "o) Anzahl der Parkplätze: Die Anzahl der Parkplätze die in der Garage verfügbar sein sollen.\n\t\t" +
                "o) Überschreiben der Historie: Wenn diese Option aktiviert wurde, wird bei neuer Simulation die" +
                "Historie überschrieben.\n");

        while (true) {
            this.println("Format: <Anzahl der Autos>, <Anzahl der Parkplätze>, <Ja/Nein>");
            this.print("Bitte geben Sie Die Einstellungen im obigen Format ein:");
            String input = this.scanner.nextLine();
            input = input.replace(" ", "");
            if (input.isEmpty()) {
                this.printErrorMessage("Sie müssen einen Wert im obigen Format eingeben. Bitte nochmal!");
                this.println();
                continue;
            }

            String[] split = input.split(",");
            if (split.length!= 3) {
                this.printErrorMessage("Sie müssen 3 Argumente angeben. Siehe Format! Bitte nochmal!");
                this.println();
                continue;
            }

            int numberOfCars;
            try {
                numberOfCars = getPositiveNumberFromUser(split[0], "Autos");
            } catch (InputMismatchException e) {
                continue;
            }

            int numberOfParkingSpaces;
            try {
                numberOfParkingSpaces = getPositiveNumberFromUser(split[1], "Parkplätze");
            } catch (InputMismatchException e) {
                continue;
            }

            switch (split[2].toLowerCase()) {
                case "ja":
                case "y":
                    return new Settings(numberOfCars, numberOfParkingSpaces, true);
                case "nein":
                case "n":
                    return new Settings(numberOfCars, numberOfParkingSpaces, false);
                default:
                    this.printErrorMessage("Ungültige Option. Bitte geben Sie eine gültige Option ein (Ja/y für ja und Nein/n für nein).");
                    break;
            }
        }
    }

    private int getPositiveNumberFromUser(String input, String object) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.printErrorMessage("Die Anzahl der "+ input + " muss eine Zahl sein! Bitte nochmal!");
            throw new InputMismatchException();
        }

        if (number < 1) {
            this.printErrorMessage("Die Anzahl der "+ input + " muss eine Zahl > 0 sein! Bitte nochmal!");
            throw new InputMismatchException();
        }

        return number;
    }

    private void print(String prompt) {
        System.out.print(prompt);
    }

    /**
     * Prints a text to the console.
     * @param toPrint The text to print.
     * @param foregroundColor The foreground color of the text.
     */
    private void printColored(String toPrint, ForegroundColor foregroundColor)
    {
        System.out.print(foregroundColor.getCode() + toPrint + ANSI_RESET);
    }

    /**
     * Prints a success message to the console.
     * @param toPrint The message to print.
     */
    public void printSuccess(String toPrint)
    {
        System.out.println();
        this.printColored("[SUCCESS]: ", ForegroundColor.GREEN);
        System.out.println(toPrint);
    }
}
