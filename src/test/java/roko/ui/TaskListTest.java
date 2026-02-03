package roko.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    private void addThreeSampleTasks(TaskList tasks) {
        tasks.add(new Todo("This is a todo"));
        tasks.add(new Deadline("This is a deadline", "2026-01-20"));
        tasks.add(new Event("This is an event", "2026-01-01", "2026-12-31"));
    }

    @Test
    public void size_addThreeTasks_isThree() {
        TaskList tasks = new TaskList();
        addThreeSampleTasks(tasks);
        assertEquals(3, tasks.size());
    }

    @Test
    public void size_removeOneTask_isTwo() {
        TaskList tasks = new TaskList();
        addThreeSampleTasks(tasks);
        tasks.removeTaskById(2);
        assertEquals(2, tasks.size());
    }
}
