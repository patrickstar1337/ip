package roko.ui;

import java.util.*;

/**
 * Represents the main bot that will be running.
 */
public class Roko {

    private UserInterface ui;

    /**
     * Creates the Roko bot for storing various tasks.
     */
    public Roko() {
        ui = new UserInterface();
        ui.printGreeting();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return "Roko heard: " + input;
    }

    public static void main(String[] args) {
    }
}
