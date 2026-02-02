package roko.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    public LocalDate dateFrom;
    public LocalDate dateTo;

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
