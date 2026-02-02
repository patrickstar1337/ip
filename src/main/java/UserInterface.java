public class UserInterface {
    public UserInterface() {

    }

    public void printGreeting() {
        System.out.println("Hello I'm ROKO");
        System.out.println("What can I do for you?");
    }

    public void printMessage(String message) {
        String formatLine = "------------------------------";
        System.out.println(formatLine + "\n" + message + "\n" + formatLine);
    }
}
