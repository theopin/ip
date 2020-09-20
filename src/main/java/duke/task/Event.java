package duke.task;

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

    @Override
    public String toString() {
        StringBuilder eventSummary = new StringBuilder();
        if(!allocatedDate.equals("")) {
            eventSummary.append(allocatedDate).append(WHITESPACE);
        }
        if(!allocatedTime.equals("")) {
            eventSummary.append(allocatedTime);
        }
        eventSummary.append(")");
        return eventSummary.toString();
    }
}
