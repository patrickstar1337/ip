package roko.ui;

/**
 * Represents a single to do task with a description and completion status.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String getTaskType() {
        return "T";
    }
}
