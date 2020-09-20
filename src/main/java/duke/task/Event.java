package duke.task;

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
        if(!allocatedDate.equals(EMPTY)) {
            eventSummary.append(allocatedDate);
            if(!allocatedTime.equals(EMPTY)) {
                eventSummary.append(WHITESPACE).append(allocatedTime);
            }
        } else if(!allocatedTime.equals(EMPTY)) {
            eventSummary.append(allocatedTime);
        }
        eventSummary.append(")");
        return eventSummary.toString();
    }
}
