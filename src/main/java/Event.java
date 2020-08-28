public class Event extends Task {
    protected String allocatedTime;

    public Event(String description, String allocatedTime) {
        super(description);
        this.allocatedTime = allocatedTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + allocatedTime + ")";
    }
}