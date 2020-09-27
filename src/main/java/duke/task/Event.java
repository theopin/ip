package duke.task;

/**
 * Represents an event type of tasks. Mainly used to mark a future
 * event for the user to take note of.
 */
public class Event extends Task {

    protected String allocatedDate;
    protected String allocatedTime;


    /**
     * Constructs a new Event Object.
     *
     * @param description Details of the Event task.
     */
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
     *
     * @return a string that contains information of the event task.
     */
    @Override
    public String toString() {
        StringBuilder eventSummary = new StringBuilder();
        eventSummary.append("[E]").append(super.toString()).append(" (at: ");
        return modifyString(eventSummary, allocatedDate, allocatedTime);
    }
}
