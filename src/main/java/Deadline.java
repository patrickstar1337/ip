public class Deadline extends Task {
    private String date;

    public Deadline(String description, String date) {
        super(description + " (by : " + date + ")");
        this.date = date;
    }

    public String getDeadline() {
        return this.date;
    }

    @Override
    public String getTaskType() {
        return "D";
    }
}
