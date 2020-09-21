package duke.task;

import duke.parser.DateTimeParser;

import static duke.task.TaskHandler.EMPTY;
import static duke.task.TaskHandler.WHITESPACE;

public class Event extends Task {

    protected String allocatedDate;
    protected String allocatedTime;

    // duke.task.Event Constructor
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

    @Override
    public String toString() {
        StringBuilder eventSummary = new StringBuilder();
        eventSummary.append("[E]").append(super.toString()).append(" (by: ");
        return modifyString(eventSummary, allocatedDate, allocatedTime);
    }
}
