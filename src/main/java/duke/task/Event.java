package duke.task;

public class Event extends Task {
    protected String allocatedTime;

    // duke.task.Event Constructor
    public Event(String description, String allocatedTime) {
        super(description);
        this.allocatedTime = allocatedTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at:" + allocatedTime + ")";
    }
}
