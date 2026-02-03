package roko.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single event task with additional from and to dates.
 */
public class Event extends Task {
    public LocalDate dateFrom;
    public LocalDate dateTo;

    /**
     * Creates a new event task
     * @param description The description of the task.
     * @param dateFrom The starting date.
     * @param dateTo The ending date.
     */
    public Event(String description, String dateFrom, String dateTo) {
        super(description);
        this.dateFrom = LocalDate.parse(dateFrom);
        this.dateTo = LocalDate.parse(dateTo);
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        String df = this.dateFrom.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String dt = this.dateTo.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return this.description + " from: (" + df + " to: " + dt + ")";
    }
}
