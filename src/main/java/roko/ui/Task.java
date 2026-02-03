package roko.ui;

/**
 * Represents a single task with description and completion status.
 * This is the parent class of all other tasks'.
 * All child classes that inherit this will have description and completion status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task with the given description.
     * Completion state is initialized as false.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns whether the task is complete or not.
     *
     * @return X if complete, otherwise a single space character.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Returns the type of task
     * @return Returns T, D, or E respectively.
     */
    public String getTaskType() {
        return "?";
    }

    @Override
    public String toString() {
        return this.description;
    }
}
