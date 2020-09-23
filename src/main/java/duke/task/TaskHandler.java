package duke.task;

import duke.data.WriteDataFile;
import duke.exception.PartialCommandException;
import duke.exception.RangeExceedException;
import duke.exception.UnknownSearchException;
import duke.message.Message;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

/**
 * Handles user commands that aim at performing certain functions related to
 * handling a task.
 */

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
    public static final String ACTION_FIND = "find";
    public static final String ACTION_REMOVE = "remove";
    public static final String WHITESPACE = " ";

    public TaskHandler(String[] userInput) {
        parseUserInput(userInput);
    }

    /**
     * Executes the action specified in the user input
     * If the position is unset, NaN is returned.
     *
     * @param userInput Command given by the user.
     */
    private void parseUserInput(String [] userInput) {
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
        case ACTION_FIND:
            try {
                String searchFilter = extractSearchFilter(userInput);
                findMatchingTasks(searchFilter);
            } catch (UnknownSearchException e) {
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

    /**
     * Removes a specified task from the list.
     *
     * @param taskNumber  Task that the user wants to be removed
     * @throws RangeExceedException  If taskNumber > size of list of tasks.
     */
    private void removeTask(String taskNumber) throws RangeExceedException {
        int oldIndex = Integer.parseInt(taskNumber) - 1;
        int maxTask = Task.getNumberOfTasks();

        if(oldIndex < 0 || oldIndex >= maxTask) {
            throw new RangeExceedException();
        }

        String deletedTask = tasks.get(oldIndex).toString();
        tasks.remove(oldIndex);
        Task.updateTaskCount();

        Message.modifyTaskSuccess(
                deletedTask, false);
        new WriteDataFile();

    }

    /**
     * Marks a specified task from the list as done.
     *
     * @param taskNumber  Task that the user wants to be set as done
     * @throws RangeExceedException  If taskNumber > size of list of tasks.
     */
    private static void setTaskAsComplete(String taskNumber) throws RangeExceedException {
        int taskIndex = Integer.parseInt(taskNumber) - 1;
        int maxTask = Task.getNumberOfTasks();

        if(taskIndex < 0 || taskIndex >= maxTask) {
            throw new RangeExceedException();
        }

        tasks.get(taskIndex).markAsDone(true);
        Message.printTaskDoneSuccess(tasks.get(taskIndex).toString());
        new WriteDataFile();
    }

    /**
     * Prints all tasks present in the list.
     */
    private static void printTaskList() {
        System.out.println("\tHere are the tasks in your list:");

        // Print each task based on a specified format
        for (Task task: tasks) {
            System.out.println("\t" + task.toString());
        }
    }
  
    private String extractSearchFilter(String[] userInput) {
        StringBuilder searchFilter = new StringBuilder();
        int userInputLength = userInput.length;
        for (int i = 0; i < userInputLength; i++) {
            if(i != 0) {
                searchFilter.append(userInput[i]);
            }
            if(i != 0 && i < userInputLength - 1) {
                searchFilter.append(WHITESPACE);
            }
        }

        return searchFilter.toString();
    }

    private void findMatchingTasks(String userFilterInput) throws UnknownSearchException {
        ArrayList<Task> filteredTasks;
        filteredTasks = (ArrayList<Task>) tasks.stream()
                .filter((s) -> s.getDescription().contains(userFilterInput))
                .collect(toList());
        if (filteredTasks.size() == 0) {
            throw new UnknownSearchException();
        }

        Message.printMatchingTasks(filteredTasks, userFilterInput);
    }

    /**
     * Creates a new task by generating specific data to be inserted from the user command
     * into this task.
     *
     * @param inputSegments  Array of strings that consist of each word of the user command.
     * @param action Name of the particular task that the user wishes to executes.
     */
    private void createNewTask(String[] inputSegments, String action) {
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
            // Inform user of success operation
            Message.modifyTaskSuccess(
                    tasks.get(newIndex).toString(), true);
            new WriteDataFile();
        } catch (PartialCommandException e) {
            e.alertException();
        }

    }

    /**
     * Creates a new task based on the action specified and inserts specific data
     * into this task.
     *
     * @param action Name of the particular task that the user wishes to executes.
     * @param newTask Description of the task.
     * @param newTaskDate Date of the task.
     * @param newTaskTime Time of the task.
     */


    public static void insertNewTask(String action, String newTask, String newTaskDate, String newTaskTime) throws PartialCommandException {
        if(action.equals(ACTION_DEADLINE) || action.equals(ACTION_EVENT)) {
            if(newTaskDate.equals(EMPTY) && newTaskTime.equals(EMPTY)) {
                throw new PartialCommandException(action + " - date and time");
            }
        }

        switch (action) {
        case ACTION_TODO:
            tasks.add(new Todo(newTask));
            break;
        case ACTION_EVENT:
            tasks.add(new Event(newTask, newTaskDate, newTaskTime));
            break;
        case ACTION_DEADLINE:
            tasks.add(new Deadline(newTask, newTaskDate, newTaskTime));
            break;
        default:
            break;
        }
    }
}

