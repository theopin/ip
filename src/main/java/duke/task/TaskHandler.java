package duke.task;

import duke.data.WriteDataFile;
import duke.exception.PartialCommandException;
import duke.exception.RangeExceedException;
import duke.message.Message;
import duke.parser.DateTimeParser;

import java.util.ArrayList;

public class TaskHandler {
    public static final String EMPTY = "";
    public static ArrayList<Task> tasks = new ArrayList<>();

    // String Constants
    public static final String ACTION_LIST = "list";
    public static final String ACTION_TODO = "todo";
    public static final String ACTION_EVENT = "event";
    public static final String ACTION_DONE = "done";
    public static final String ACTION_DEADLINE = "deadline";
    public static final String ACTION_EXIT = "bye";
    public static final String ACTION_REMOVE = "remove";
    public static final String WHITESPACE = " ";

    public TaskHandler(String[] userInput) {
        parseUserInput(userInput);
    }

    // Deciphers the action to be done based on the input
    public void parseUserInput(String [] userInput) {
        String action = userInput[0];

        // Run the respective methods based on the action
        switch(action) {
        case ACTION_DONE:
            try {
                setTaskAsComplete(userInput[1]);
            } catch (RangeExceedException e) {
                e.alertException();
            }
            break;
        case ACTION_REMOVE:
            try {
                removeTask(userInput[1]);
            } catch (RangeExceedException e) {
                e.alertException();
            }
            break;
        case ACTION_LIST:
            printTaskList();
            break;
        case ACTION_TODO:
            createNewTask(userInput, ACTION_TODO);
            break;
        case ACTION_EVENT:
            createNewTask(userInput, ACTION_EVENT);
            break;
        case ACTION_DEADLINE:
            createNewTask(userInput, ACTION_DEADLINE);
            break;
        case ACTION_EXIT:
            return;
        default:
            break;
        }

        Message.printHorizontalLine();
    }

    private void removeTask(String taskNumber) throws RangeExceedException {
        int oldIndex = Integer.parseInt(taskNumber) - 1;
        int maxTask = Task.getNumberOfTasks();

        if(oldIndex < 0 || oldIndex >= maxTask) {
            throw new RangeExceedException();
        }

        String deletedTask = tasks.get(oldIndex).toString();
        tasks.remove(oldIndex);
        Task.taskRemoved();

        Message.modifyTaskSuccess(
                deletedTask, false);
        new WriteDataFile();

    }

    // Sets the particular task as done
    public static void setTaskAsComplete(String taskNumber) throws RangeExceedException {
        int taskIndex = Integer.parseInt(taskNumber) - 1;
        int maxTask = Task.getNumberOfTasks();

        if(taskIndex < 0 || taskIndex >= maxTask) {
            throw new RangeExceedException();
        }

        tasks.get(taskIndex).markAsDone(true);
        Message.printTaskDoneSuccess(tasks.get(taskIndex).toString());
        new WriteDataFile();
    }

    // Prints the whole list of tasks
    public static void printTaskList() {
        System.out.println("\tHere are the tasks in your list:");

        // Print each task based on a specified format
        for (Task task: tasks) {
            System.out.println("\t" + task.toString());
        }
    }

    // Creates a new task based on its type
    public static void createNewTask(String[] inputSegments, String action) {
        int newIndex = Task.getNumberOfTasks();
        boolean hasReachedSplit = false;
        StringBuilder newTask = new StringBuilder();
        String newTaskDate = EMPTY;
        String newTaskTime = EMPTY;

        for (String inputSegment : inputSegments) {
            if(inputSegment.contains("/") && !hasReachedSplit) {
                hasReachedSplit = true;
            } else if(!hasReachedSplit && !inputSegment.equals(action)) {
                newTask.append(WHITESPACE).append(inputSegment);
            } else if(hasReachedSplit)  {
                if(inputSegment.contains("/")) {
                    newTaskDate = inputSegment.trim();
                } else if(inputSegment.contains(":")) {
                    newTaskTime = inputSegment.trim();
                }
            }
        }

        // Creates a new task type based on the type specified
        try {
            insertNewTask(action, newTask.toString().trim(), newTaskDate, newTaskTime);
        } catch (PartialCommandException e) {
            e.alertException();
        }

        // Inform user of success operation
        Message.modifyTaskSuccess(
                tasks.get(newIndex).toString(), true);
        new WriteDataFile();

    }

    public static void insertNewTask(String action, String newTask, String newTaskDate, String newTaskTime) throws PartialCommandException {
        String formattedTaskDate = EMPTY;
        String formattedTaskTime = EMPTY;

        if(action.equals(ACTION_DEADLINE) || action.equals(ACTION_EVENT)) {
            if(newTaskDate.equals(EMPTY) && newTaskTime.equals(EMPTY)) {
                throw new PartialCommandException(action + "- date and time");
            }
            if(!newTaskDate.equals(EMPTY)) {
                formattedTaskDate = DateTimeParser.parseDate(newTaskDate);
            }
            if(!newTaskTime.equals(EMPTY)) {
                formattedTaskTime = DateTimeParser.parseTime(newTaskTime);
            }
        }

        switch (action) {
        case ACTION_TODO:
            tasks.add(new Todo(newTask));
            break;
        case ACTION_EVENT:
            tasks.add(new Event(newTask, formattedTaskDate, formattedTaskTime));
            break;
        case ACTION_DEADLINE:
            tasks.add(new Deadline(newTask, formattedTaskDate, formattedTaskTime));
            break;
        default:
            break;
        }
    }
}

