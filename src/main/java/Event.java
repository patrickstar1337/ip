public class Event extends Task {
    public String dateFrom;
    public String dateTo;

    public Event(String description, String dateFrom, String dateTo) {
        super(description);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        return this.description + " from: (" + dateFrom + " to: " + dateTo + ")";
    }
}
