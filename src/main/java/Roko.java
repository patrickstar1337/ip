import java.util.*;

public class Roko {
    public static void main(String[] args) {
        List<String> localdb = new ArrayList<>();

        System.out.println("Hello I'm ROKO");
        System.out.println("What can I do for you?");

        Scanner scan = new Scanner(System.in);
        String formatLine = "\n------------------------------\n";
        while (true) {
            String userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(formatLine + "Bye. Hope to see you again!" + formatLine);
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                int count = 1;
                for (String i : localdb) {
                    System.out.println(count + ". " + i);
                    count++;
                }
            } else {
                System.out.println(formatLine + "added: " + userInput + formatLine);
                localdb.add(userInput);
            }
        }
    }
}
