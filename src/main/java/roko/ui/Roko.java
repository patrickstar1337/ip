package roko.ui;

import java.util.*;

/**
 * Represents the main bot that will be running.
 */
public class Roko {

    private UserInterface ui;
//    private Parser parser;

    /**
     * Creates the Roko bot for storing various tasks.
     */
    public Roko() {
        ui = new UserInterface();
//        parser = new Parser();
        ui.printGreeting();
    }

    /**
     * Runs the bot and takes in user inputs for various commands.
     */
//    public void run() {
//        Scanner scan = new Scanner(System.in);
//        do {
//            String c = scan.nextLine();
//            parser.parseCommand(c);
//        } while (!Parser.isDone);
//    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return "Roko heard: " + input;
    }

    public static void main(String[] args) {
//        new Roko().run();
    }
}
