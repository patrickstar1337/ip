import java.util.*;

public class Roko {
    public static void main(String[] args) {
        System.out.println("Hello I'm ROKO");
        System.out.println("What can I do for you?");

        Scanner scan = new Scanner(System.in);
        String formatLine = "\n------------------------------\n";
        while (true) {
            String userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(formatLine + "Bye. Hope to see you again!" + formatLine);
                break;
            } else {
                System.out.println(formatLine + userInput + formatLine);
            }
        }
    }
}
