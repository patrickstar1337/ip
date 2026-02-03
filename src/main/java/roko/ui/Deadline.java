package roko.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single deadline task with an additional deadline date field.
 */
public class Deadline extends Task {
    public LocalDate date;

    /**
     * Creates a new deadline task.
     * @param description The description of the task.
     * @param date The date of which the task is to be done by.
     */
    public Deadline(String description, String date) {
        super(description);
        this.date = LocalDate.parse(date);
    }

    public String getDeadline() {
        return this.date.toString();
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        String d = this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return this.description + " (by : " + d + ")";
    }
}
