package duke.task;

import duke.exception.RangeExceedException;

/**
 * Represents an event type of tasks. Mainly used to mark a future
 * event for the user to take note of.
 */
public class Event extends Task {
    protected String allocatedTime;

    // Event Constructor
    public Event(String description, String allocatedTime) {
        super(description);
        this.allocatedTime = allocatedTime;
    }

    public String getAllocatedTime() {
        return allocatedTime;
    }

    /**
     * Converts the Event Task into a string.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + allocatedTime + ")";
    }
}
