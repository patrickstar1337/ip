public class Deadline extends Task {
    protected String description;
    private String date;

    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String getTaskType() {
        return "[D]";
    }
}
