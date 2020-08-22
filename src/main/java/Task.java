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

    //return tick or X symbols
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }
}
