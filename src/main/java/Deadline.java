public class Deadline extends Task {
    public String date;

    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }

    public String getDeadline() {
        return this.date;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return this.description + " (by : " + this.date + ")";
    }
}
