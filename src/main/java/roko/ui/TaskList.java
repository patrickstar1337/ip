package roko.ui;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }
    public TaskList(List<Task> t) {
        taskList = t;
    }

    public void add(Task t) {
        taskList.add(t);
    }

    public int size() {
        return taskList.size();
    }

    public Task getTaskById(int id) {
        return taskList.get(id);
    }

    public void removeTaskById(int id) {
        taskList.remove(this.getTaskById(id));
    }

    public void save() {
        Storage s = new Storage();
        s.save(taskList);
    }

    public List<Task> getAllTasks() {
        return this.taskList;
    }
}
