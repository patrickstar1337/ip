package roko.ui;

/**
 * Represents the class that is responsible for taking user input.
 */
public class Parser {
    private RokoBOT roko = new RokoBOT();
    public static boolean isDone = false;

    public Parser() {

    }

    /**
     * Parses the user's input into commands that are then executed.
     * @param c The user input String.
     */
    public void parseCommand(String c) {
        String command = "";

        // Check for valid command
        try {
            RokoBOT.checkValidInput(c);
            command = c.split(" ")[0];
        } catch (RokoEmptyDescException | RokoUnknownCommandException e) {
            System.out.println(e.getMessage());
        }

        // Commands for ROKO
        if (command.equalsIgnoreCase("mark")) {
            int id = Integer.parseInt(c.split(" ")[1]) - 1;
            roko.mark(id);
        } else if (command.equalsIgnoreCase("unmark")) {
            int id = Integer.parseInt(c.split(" ")[1]) - 1;
            roko.unmark(id);
        } else if (command.equalsIgnoreCase("todo")) {
            String description = c.substring(5);
            roko.addTodo(description);
        } else if (command.equalsIgnoreCase("list")) {
            roko.printAllTasks();
        } else if (command.equalsIgnoreCase("deadline")) {
            String[] s = c.substring(9).split("/");
            String description = s[0].substring(0, s[0].length() - 1);
            String date = s[1].substring(3);
            roko.addDeadline(description, date);
        } else if (command.equalsIgnoreCase("event")) {
            String[] s = c.substring(6).split("/");
            String description = s[0].substring(0, s[0].length() - 1);
            String dateFrom = s[1].substring(5, s[1].length() - 1);
            String dateTo = s[2].substring(3);
            roko.addEvent(description, dateFrom, dateTo);
        } else if (command.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(c.split(" ")[1]) - 1;
            roko.delete(id);
        } else if (command.equalsIgnoreCase("bye")) {
            roko.save();
            Parser.isDone = true;
            System.out.println("Good Bye!");
        }
    }
}
