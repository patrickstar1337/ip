import java.util.*;

public class Roko {
    public static void main(String[] args) {
        List<Task> localdb = new ArrayList<>();

        System.out.println("Hello I'm ROKO");
        System.out.println("What can I do for you?");

        Scanner scan = new Scanner(System.in);
        String formatLine = "\n------------------------------\n";
        while (true) {
            String userInput = scan.nextLine();
            if (userInput.toLowerCase().contains("mark")) {
                String[] temp = userInput.split(" ");
                String command = temp[0];
                int taskNo = Integer.parseInt(temp[1]) - 1;
                if (command.equals("mark")) {
                    localdb.get(taskNo).isDone = true;
                    System.out.println("I've marked this as done:");
                    System.out.println("[" + localdb.get(taskNo).getStatusIcon() + "] " +
                            localdb.get(taskNo).description);
                } else {
                    localdb.get(taskNo).isDone = false;
                    System.out.println("I've marked this as NOT done yet:");
                    System.out.println("[" + localdb.get(taskNo).getStatusIcon() + "] " +
                            localdb.get(taskNo).description);
                }
                continue;
            }
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(formatLine + "Bye. Hope to see you again!" + formatLine);
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                int count = 1;
                for (Task task : localdb) {
                    System.out.println(count + ".[" + task.getStatusIcon() + "] " + task.description);
                    count++;
                }
            } else {
                System.out.println(formatLine + "added: " + userInput + formatLine);
                Task t = new Task(userInput);
                localdb.add(t);
            }
        }
    }
}
