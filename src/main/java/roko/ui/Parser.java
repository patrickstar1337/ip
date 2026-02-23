package roko.ui;

/**
 * Represents the class that is responsible for taking user input.
 */
public class Parser {
    private static RokoBOT roko = new RokoBOT();
    public static boolean isDone = false;

    public Parser() {

    }

    /**
     * Parses the user's input into commands that are then executed.
     * @param c The user input String.
     */
    public String parseCommand(String c) {
        String command = "";

        // Check for valid command
        try {
            RokoBOT.checkValidInput(c);
            command = c.split(" ")[0];
        } catch (RokoEmptyDescException | RokoUnknownCommandException e) {
            return e.getMessage();
//            System.out.println(e.getMessage());
        }

        // Commands for ROKO
        if (command.equalsIgnoreCase("mark")) {
            int id = Integer.parseInt(c.split(" ")[1]) - 1;
            return roko.mark(id);
        } else if (command.equalsIgnoreCase("unmark")) {
            int id = Integer.parseInt(c.split(" ")[1]) - 1;
            return roko.unmark(id);
        } else if (command.equalsIgnoreCase("todo")) {
            String description = c.substring(5);
            return roko.addTodo(description);
        } else if (command.equalsIgnoreCase("list")) {
            return roko.printAllTasks();
        } else if (command.equalsIgnoreCase("deadline")) {
            String[] s = c.substring(9).split("/");
            String description = "";
            String date = "";
            try {
                description = s[0].substring(0, s[0].length() - 1);
                date = s[1].substring(3);
            } catch (Exception e) {
                return "Please enter valid command (deadline [keyword] /by [yyyy-mm-dd])";
            }
            return roko.addDeadline(description, date);
        } else if (command.equalsIgnoreCase("event")) {
            String[] s = c.substring(6).split("/");
            String description = s[0].substring(0, s[0].length() - 1);
            String dateFrom = s[1].substring(5, s[1].length() - 1);
            String dateTo = s[2].substring(3);
            return roko.addEvent(description, dateFrom, dateTo);
        } else if (command.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(c.split(" ")[1]) - 1;
            return roko.delete(id);
        } else if (command.equalsIgnoreCase("find")) {
            return roko.findByKeyword(c.split(" ")[1]);
        } else if (command.equalsIgnoreCase("undo")) {
            return roko.undo();
        } else if (command.equalsIgnoreCase("bye")) {
            roko.save();
            Parser.isDone = true;
            System.out.println("Good Bye!");
        }
        return "";
    }
}
