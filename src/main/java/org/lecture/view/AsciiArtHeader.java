package org.lecture.view;

public class AsciiArtHeader {

    public static void printAsciiArtHeader() {

        String[] headerLines = {
                " ________  ________  ________  ___  __    ___  ___  ________  ___  ___  ________                 ________  ________  ___  ___  ________  ________  _______           ________     ",
                "|\\   __  \\|\\   __  \\|\\   __  \\|\\  \\|\\  \\ |\\  \\|\\  \\|\\   __  \\|\\  \\|\\  \\|\\   ____\\               |\\   ____\\|\\   __  \\|\\  \\|\\  \\|\\   __  \\|\\   __  \\|\\  ___ \\         |\\   __  \\    ",
                "\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\/  /|\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\___|_  ____________\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\   __/|        \\ \\  \\|\\  \\   ",
                " \\ \\   ____\\ \\   __  \\ \\   _  _\\ \\   ___  \\ \\   __  \\ \\   __  \\ \\  \\\\\\  \\ \\_____  \\|\\____________\\ \\  \\  __\\ \\   _  _\\ \\  \\\\\\  \\ \\   ____\\ \\   ____\\ \\  \\_|/__       \\ \\   __  \\  ",
                "  \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\\\ \\  \\ \\  \\ \\  \\ \\  \\ \\  \\ \\  \\\\\\  \\|____|\\  \\|____________|\\ \\  \\|\\  \\ \\  \\\\  \\\\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\___|\\ \\  \\_|\\ \\       \\ \\  \\ \\  \\ ",
                "   \\ \\__\\    \\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\__\\\\ \\__\\ \\__\\ \\__\\ \\__\\ \\__\\ \\_______\\____\\_\\  \\              \\ \\_______\\ \\__\\\\ _\\\\ \\_______\\ \\__\\    \\ \\__\\    \\ \\_______\\       \\ \\__\\ \\__\\",
                "    \\|__|     \\|__|\\|__|\\|__|\\|__|\\|__| \\|__|\\|__|\\|__|\\|__|\\|__|\\|_______|\\_________\\              \\|_______|\\|__|\\|__|\\|_______|\\|__|     \\|__|     \\|_______|        \\|__|\\|__|",
                "                                                                          \\|_________|                                                                                          ",
                "                                                                                                                                                                                  ",
                "                                                                                                                                                                                  "
        };

        String horizontalBorder = "═";
        String verticalBorder = "║";
        String cornerTopLeft = "╔";
        String cornerTopRight = "╗";
        String cornerBottomLeft = "╚";
        String cornerBottomRight = "╝";

        int maxWidth = 0;
        for (String line : headerLines) {
            maxWidth = Math.max(maxWidth, line.length());
        }

        String topBorder = cornerTopLeft + new String(new char[maxWidth + 2]).replace("\0", horizontalBorder) + cornerTopRight;
        String bottomBorder = cornerBottomLeft + new String(new char[maxWidth + 2]).replace("\0", horizontalBorder) + cornerBottomRight;

        System.out.println(topBorder);
        for (String line : headerLines) {
            while (line.length() < maxWidth) {
                line += " ";
            }

            System.out.println(verticalBorder + " " + line + " " + verticalBorder);
        }

        System.out.println(bottomBorder);
    }

    public static void main(String[] args) {
        printAsciiArtHeader();
    }
}


