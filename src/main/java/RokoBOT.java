import java.util.ArrayList;
import java.util.List;

public class RokoBOT {
    List<Task> localdb;

    public RokoBOT() {
        localdb = new ArrayList<>();
        printGreeting();
    }

    public void addTodo(String description) {
        Todo todo = new Todo(description);
        localdb.add(todo);
        String message = String.format("Got it. I've added this task:\n[%s][%s] %s\nNow you have %o tasks",
                todo.getTaskType(), todo.getStatusIcon(), todo.description, getTotalTasks());
        printMessage(message);
    }

    public void addDeadline(String description, String date) {
        Deadline deadline = new Deadline(description, date);
        localdb.add(deadline);
        String message = String.format("Got it. I've added this task:\n[%s][%s] %s\nNow you have %o tasks",
                deadline.getTaskType(), deadline.getStatusIcon(), deadline.description, getTotalTasks());
        printMessage(message);
    }

    public void addEvent(String description, String dateFrom, String dateTo) {
        Event event = new Event(description, dateFrom, dateTo);
        localdb.add(event);
        String message = String.format("Got it. I've added this task:\n[%s][%s] %s\nNow you have %o tasks",
                event.getTaskType(), event.getStatusIcon(), event.description, getTotalTasks());
        printMessage(message);
    }

    public int getTotalTasks() {
        return localdb.size();
    }

    public void mark(int id) {
        Task task = localdb.get(id);
        task.isDone = true;
        String message = "Nice! I've marked this as done: " + "\n" + "[" +
                task.getStatusIcon() + "] " + task.description;
        printMessage(message);
    }

    public void unmark(int id) {
        Task task = localdb.get(id);
        task.isDone = false;
        String message = "Alright, I've marked this as NOT done: " + "\n" + "[" +
                task.getStatusIcon() + "] " + task.description;
        printMessage(message);
    }

    public void printGreeting() {
        System.out.println("Hello I'm ROKO");
        System.out.println("What can I do for you?");
    }

    public void printMessage(String message) {
        String formatLine = "------------------------------";
        System.out.println(formatLine + "\n" + message + "\n" + formatLine);
    }

    public void printAllTasks() {
        String message = "Here are ALL your tasks:\n";
        int count = 1;
        for (Task task : localdb) {
            String row = String.format("%o.[%s][%s] %s", count, task.getTaskType(), task.getStatusIcon(),
                    task.description);
            message += row + "\n";
            count++;
        }
        printMessage(message);
    }
}
