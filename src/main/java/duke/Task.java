package duke;

public class Task {
    protected String description;
    protected boolean isDone = false;
    protected static int numberOfTasks = 0;

    // duke.Task Constructor
    public Task(String description) {
        this.description = description;
        numberOfTasks++;
    }

    // Returns description of tasks
    public String getDescription() {
        return description;
    }

    // Returns tick or X symbols based on the value of isDone
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    // Sets the isDone variable of the task
    public void markAsDone(boolean isDone) {
        this.isDone = isDone;
    }

    // Returns the number of Tasks created so far
    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + getDescription();
    }
}
