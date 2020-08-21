public class Task {
    private String description;
    private boolean isDone = false;
    private static int numberOfTasks = 0;

    public Task(String description) {
        this.description = description;
        numberOfTasks++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //return tick or X symbols
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }
}
