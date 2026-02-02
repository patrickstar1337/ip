import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    public LocalDate date;

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
