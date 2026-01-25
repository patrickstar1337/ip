public class Event extends Task {
    protected String description;
    public String dateFrom;
    public String dateTo;

    public Event(String description, String dateFrom, String dateTo) {
        super(description);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public String getTaskType() {
        return "[D]";
    }
}
