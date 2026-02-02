import java.util.*;

public class Roko {
    public static void main(String[] args) {
        RokoBOT roko = new RokoBOT();
        RokoDatabase rokoData = new RokoDatabase();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String userInput = scan.nextLine();
            String command = "";

            // Check for valid command
            try {
                RokoBOT.checkValidInput(userInput);
                command = userInput.split(" ")[0];
            } catch (RokoEmptyDescException | RokoUnknownCommandException e) {
                System.out.println(e.getMessage());
            }

            // Commands for ROKO
            if (command.equalsIgnoreCase("mark")) {
                int id = Integer.parseInt(userInput.split(" ")[1]) - 1;
                roko.mark(id);
            } else if (command.equalsIgnoreCase("unmark")) {
                int id = Integer.parseInt(userInput.split(" ")[1]) - 1;
                roko.unmark(id);
            } else if (command.equalsIgnoreCase("todo")) {
                String description = userInput.substring(5);
                roko.addTodo(description);
            } else if (command.equalsIgnoreCase("list")){
                roko.printAllTasks();
            } else if (command.equalsIgnoreCase("deadline")) {
                String[] s = userInput.substring(9).split("/");
                String description = s[0].substring(0, s[0].length() - 1);
                String date = s[1].substring(3);
                roko.addDeadline(description, date);
            } else if (command.equalsIgnoreCase("event")) {
                String[] s = userInput.substring(6).split("/");
                String description = s[0].substring(0, s[0].length() - 1);
                String dateFrom = s[1].substring(5);
                String dateTo = s[2].substring(3);
                roko.addEvent(description, dateFrom, dateTo);
            } else if (command.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(userInput.split(" ")[1]) - 1;
                roko.delete(id);
            } else if (command.equalsIgnoreCase("bye")) {
                roko.save();
                System.out.println("Good Bye!");
                break;
            }
        }
    }
}
