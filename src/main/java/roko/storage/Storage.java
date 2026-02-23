package roko.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import roko.ui.Deadline;
import roko.ui.Event;
import roko.ui.Task;
import roko.ui.Todo;

/**
 * Saves tasks' data into a text file located at data/tasks.txt.
 */
public class Storage {
    public Storage() {

    }

    /**
     * Loads data/tasks.txt into the program.
     * If no file found, an empty new one will be created.
     *
     * @return List<Task> of tasks.
     * @throws FileNotFoundException If file doesn't exist.
     */
    public List<Task> initialise() throws FileNotFoundException {
        List<Task> localdb = new ArrayList<>();
        File f = new File("data/tasks.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String[] task = s.nextLine().split("\\|");
            switch (task[0]) {
            case "T":
                Todo t = new Todo(task[1]);
                t.setIsDone(task[2].equals("Y"));
                localdb.add(t);
                break;
            case "D":
                Deadline d = new Deadline(task[1], task[2]);
                d.setIsDone(task[3].equals("Y"));
                localdb.add(d);
                break;
            case "E":
                Event e = new Event(task[1], task[2], task[3]);
                e.setIsDone(task[4].equals("Y"));
                localdb.add(e);
                break;
            }
        }
        return localdb;
    }

    /**
     * Saves a given ArrayList of Tasks into data/tasks.txt
     */
    public void save(List<Task> localdb) {
        StringBuilder data = new StringBuilder();
        for (Task t : localdb) {
            String type = t.getTaskType();
            String isDone = t.getIsDone() ? "Y" : "N";
            switch (type) {
            case "T":
                // Type | Description | Is Done
                String todo = type + "|" + t.getDescription() + "|" + isDone + System.lineSeparator();
                data.append(todo);
                break;
            case "D":
                // Type | Description | Date | Is Done
                Deadline d = (Deadline) t;
                String deadline = type + "|" + d.getDescription() + "|" + d.getDeadline() + "|" + isDone +
                        System.lineSeparator();
                data.append(deadline);
                break;
            case "E":
                // Type | Description | From Date | To Date | Is Done
                Event e = (Event) t;
                String event = type + "|" + e.getDescription() + "|" + e.dateFrom + "|" + e.dateTo + "|" + isDone +
                        System.lineSeparator();
                data.append(event);
                break;
            }
        }

        try {
            File f = new File("data/tasks.txt");
            f.getParentFile().mkdirs();
            f.createNewFile();
            FileWriter fw = new FileWriter("data/tasks.txt");
            fw.write(data.toString());
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
