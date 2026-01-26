import java.util.*;

public class Roko {
    public static void main(String[] args) {
        RokoBOT roko = new RokoBOT();
        Scanner scan = new Scanner(System.in);
//        String[] validCommands = new String[] {"mark", "unmark", "list", "bye", "todo", "deadline", "event"};
        while (true) {
            String userInput = scan.nextLine();
            String command = userInput.split(" ")[0];

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
            }

//            if (userInput.toLowerCase().contains("mark")) {
//                String[] temp = userInput.split(" ");
//                String command = temp[0];
//                int taskNo = Integer.parseInt(temp[1]) - 1;
//                if (command.equals("mark")) {
//                    localdb.get(taskNo).isDone = true;
//                    System.out.println("I've marked this as done:");
//                    System.out.println("[" + localdb.get(taskNo).getStatusIcon() + "] " +
//                            localdb.get(taskNo).description);
//                } else {
//                    localdb.get(taskNo).isDone = false;
//                    System.out.println("I've marked this as NOT done yet:");
//                    System.out.println("[" + localdb.get(taskNo).getStatusIcon() + "] " +
//                            localdb.get(taskNo).description);
//                }
//                continue;
//            }
//            if (userInput.equalsIgnoreCase("bye")) {
//                System.out.println(formatLine + "Bye. Hope to see you again!" + formatLine);
//                break;
//            } else if (userInput.equalsIgnoreCase("list")) {
//                int count = 1;
//                for (Task task : localdb) {
//                    System.out.println(count + ".[" + task.getStatusIcon() + "] " + task.description);
//                    count++;
//                }
//            } else {
//                System.out.println(formatLine + "added: " + userInput + formatLine);
//                Task t = new Task(userInput);
//                localdb.add(t);
//            }
        }
    }
}
