package duke;

import duke.exception.IllegalCommandException;
import duke.exception.RangeExceedException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.Scanner;

public class UserSession {
    // Scanner for user input
    private static final Scanner myScanner = new Scanner(System.in);

    // String Constants
    private static final String ACTION_LIST = "list";
    private static final String ACTION_DONE = "done";
    private static final String ACTION_TODO = "todo";
    private static final String ACTION_EVENT = "event";
    private static final String ACTION_DEADLINE = "deadline";
    private static final String ACTION_EXIT = "bye";
    private static final String WHITESPACE = " ";

    // duke.task.Task array
    public static final int MAX_TASKS = 100;
    public static Task[] tasks = new Task[MAX_TASKS];

    public UserSession() {
        runProgramSequence();
    }

    // Overall structure of a user session
    public void runProgramSequence() {
        String action = "";
        Message.printWelcomeText();

        // Ask for new user input until user types an exit command
        do {
            try {
                String[] userInput = receiveUserInput();
                userInput[0] = userInput[0].toLowerCase();
                parseUserInput(userInput);
                action = userInput[0];
            } catch (IllegalCommandException e) {
                e.alertException();
            }
;
        } while(!action.equals(ACTION_EXIT));
        Message.printExitText();
    }

    // Takes in input from the user
    public String[] receiveUserInput() throws IllegalCommandException {
        String userCommand = myScanner.nextLine().trim();
        Message.printHorizontalLine();
        String[] splitCommand = userCommand.split(WHITESPACE);

        if(splitCommand.length <= 1 && !splitCommand[0].equals(ACTION_LIST)) {
            throw new IllegalCommandException();
        }

        return splitCommand;
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

    // Sets the particular task as done
    public static void setTaskAsComplete(String taskNumber) throws RangeExceedException {
        int index = Integer.parseInt(taskNumber) - 1;
        int maxTask = Task.getNumberOfTasks();

        if(index < 0 || index >= maxTask) {
            throw new RangeExceedException();
        }

        tasks[index].markAsDone(true);
        Message.printTaskDoneSuccess(tasks[index].toString());
    }

    // Prints the whole list of tasks
    public static void printTaskList() {
        System.out.println("\tHere are the tasks in your list:");

        // Print each task based on a specified format
        int iterations = Task.getNumberOfTasks();
        for (int i = 0; i < iterations; i++) {
            System.out.println("\t" + tasks[i].toString());
        }
    }

    // Creates a new task based on its type
    public static void createNewTask(String[] inputSegments, String action) {
        int new_index = Task.getNumberOfTasks();
        boolean hasReachedSplit = false;
        StringBuilder newTask = new StringBuilder();
        StringBuilder newTaskTimeline = new StringBuilder();

        for (String inputSegment : inputSegments) {
            if(inputSegment.contains("/")) {
                hasReachedSplit = true;
            } else if(!hasReachedSplit && !inputSegment.equals(action)) {
                newTask.append(WHITESPACE).append(inputSegment);
            } else if(hasReachedSplit)  {
                newTaskTimeline.append(WHITESPACE).append(inputSegment);
            }
        }

        // Creates a new task type based on the type specified
        switch (action) {
        case ACTION_TODO:
            tasks[new_index] = new Todo(newTask.toString());
            break;
        case ACTION_EVENT:
            tasks[new_index] = new Event(newTask.toString(), newTaskTimeline.toString());
            break;
        case ACTION_DEADLINE:
            tasks[new_index] = new Deadline(newTask.toString(), newTaskTimeline.toString());
            break;
        default:
            break;
        }

        // Inform user of success operation
        Message.printTaskAddSuccess(
                tasks[new_index].toString(), new_index);
    }
}
