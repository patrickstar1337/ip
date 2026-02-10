package roko.ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RokoBOT {
    List<Task> localdb;
    TaskList tasks;
    Storage rokoData = new Storage();
    UserInterface ui = new UserInterface();

    public RokoBOT() {
        localdb = new ArrayList<>();
        Storage rokoData = new Storage();
        try {
            tasks = new TaskList(rokoData.initialise());
        } catch (FileNotFoundException e) {
            tasks = new TaskList();
        }
    }

    /**
     * Checks if the user input is a valid command.
     * @param input The user input.
     * @throws RokoUnknownCommandException If it's an unknown command.
     * @throws RokoEmptyDescException If the description for the command is empty.
     */
    public static void checkValidInput(String input) throws RokoUnknownCommandException, RokoEmptyDescException {
        String[] validCommands = new String[] {"mark", "unmark", "list", "bye",
                "todo", "deadline", "event", "bye", "delete", "find"};
        if (input.length() <= 1 || input.split(" ").length < 1 ||
                !Arrays.asList(validCommands).contains(input.split(" ")[0])) {
            throw new RokoUnknownCommandException("Error: Empty or not a valid command");
        }
        String command = input.split(" ")[0];
        if (input.split(" ").length == 1 && !command.equalsIgnoreCase("list")
                && !command.equalsIgnoreCase("bye")) {
            throw new RokoEmptyDescException("Error: No description given");
        }
    }

    /**
     * Adds a To do task to the list.
     * @param description The description of the task.
     */
    public String addTodo(String description) {
        Todo todo = new Todo(description);
        tasks.add(todo);
        String message = String.format("Got it. I've added this task:\n[%s][%s] %s\nNow you have %o tasks",
                todo.getTaskType(), todo.getStatusIcon(), todo.description, getTotalTasks());
        ui.printMessage(message);
        return message;
    }

    /**
     * Adds a deadline task to the list.
     * @param description The description of the task.
     * @param date The deadline of the task.
     */
    public String addDeadline(String description, String date) {
        Deadline deadline = new Deadline(description, date);
        tasks.add(deadline);
        String message = String.format("Got it. I've added this task:\n[%s][%s] %s\nNow you have %o tasks",
                deadline.getTaskType(), deadline.getStatusIcon(), deadline.description, getTotalTasks());
        ui.printMessage(message);
        return message;
    }

    /**
     * Adds an event task to the list.
     * @param description The description of the task.
     * @param dateFrom The beginning date.
     * @param dateTo The ending date.
     */
    public String addEvent(String description, String dateFrom, String dateTo) {
        Event event = new Event(description, dateFrom, dateTo);
        tasks.add(event);
        String message = String.format("Got it. I've added this task:\n[%s][%s] %s\nNow you have %o tasks",
                event.getTaskType(), event.getStatusIcon(), event.description, getTotalTasks());
        ui.printMessage(message);
        return message;
    }

    public int getTotalTasks() {
        return tasks.size();
    }

    /**
     * Marks a certain task as complete.
     * @param id The task id.
     */
    public String mark(int id) {
        Task task = tasks.getTaskById(id);
        task.isDone = true;
        String message = "Nice! I've marked this as done: " + "\n" + "[" +
                task.getStatusIcon() + "] " + task;
        ui.printMessage(message);
        return message;
    }

    /**
     * Marks a certain task as incomplete.
     * @param id The task id.
     */
    public String unmark(int id) {
        Task task = tasks.getTaskById(id);
        task.isDone = false;
        String message = "Alright, I've marked this as NOT done: " + "\n" + "[" +
                task.getStatusIcon() + "] " + task;
        ui.printMessage(message);
        return message;
    }

    /**
     * Removes a task from the list.
     * @param id The task id.
     */
    public String delete(int id) {
        Task task = tasks.getTaskById(id);
        tasks.removeTaskById(id);
        String message = String.format("I have deleted your task:\n[%s][%s] %s\nNow you have %o tasks left",
                task.getTaskType(), task.getStatusIcon(), task.description, getTotalTasks());
        ui.printMessage(message);
        return message;
    }

    public void save() {
        tasks.save();
    }

    /**
     * Prints out all the tasks in the list.
     */
    public String printAllTasks() {
        String message = "Here are ALL your tasks:";
        int count = 1;
        for (Task task : tasks.getAllTasks()) {
            String row = String.format("%o.[%s][%s] %s", count, task.getTaskType(), task.getStatusIcon(),
                    task);
            message += "\n" + row;
            count++;
        }
        ui.printMessage(message);
        return message;
    }

    public String findByKeyword(String keyword) {
        String message = "Here are the matching tasks in your list:";
        int count = 0;
        for (Task task : tasks.getAllTasks()) {
            if (task.description.contains(keyword)) {
                String row = String.format("%o.[%s][%s] %s", count + 1, task.getTaskType(), task.getStatusIcon(),
                        task);
                message += "\n" + row;
                count++;
            }
        }
        if (count == 0) {
            message = "No task matched that keyword!";
        }
        ui.printMessage(message);
        return message;
    }
}
