package duke.task;

/**
 * Represents an event type of tasks. Mainly used to mark a future
 * event for the user to take note of.
 */
public class Event extends Task {

    protected String allocatedDate;
    protected String allocatedTime;


    // Event Constructor
    public Event(String description, String allocatedDate, String allocatedTime) {
        super(description);
        this.allocatedDate = allocatedDate;
        this.allocatedTime = allocatedTime;
    }

    public String getAllocatedTime() {
        return allocatedTime;
    }

    public String getAllocatedDate() {
        return allocatedDate;
    }

    /**
     * Converts the Event Task into a string.
     */
    @Override
    public String toString() {
        StringBuilder eventSummary = new StringBuilder();
        eventSummary.append("[E]").append(super.toString()).append(" (at: ");
        return modifyString(eventSummary, allocatedDate, allocatedTime);
    }
}
