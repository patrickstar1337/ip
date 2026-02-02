package roko.ui;

import java.util.*;

public class Roko {

    private UserInterface ui;
    private Parser parser;

    public Roko() {
        ui = new UserInterface();
        parser = new Parser();
        ui.printGreeting();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        do {
            String c = scan.nextLine();
            parser.parseCommand(c);
        } while (!Parser.isDone);
    }

    public static void main(String[] args) {
        new Roko().run();
    }
}
