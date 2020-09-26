package duke.message;

import duke.task.Task;
import java.util.ArrayList;

/**
 * A class that stores methods aimed at printing out certain messages when
 * the user has activated certain features of a function.
 */
public class Message {
    /**
     * Prints the initial greetings when the user loads the program.
     */
    public static void printWelcomeText() {
        // Print a horizontal line and duke logo
        printHorizontalLine();
        String logo = "\t ____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";

        // Print greetings and a horizontal line
        System.out.println("\tHello from\n" + logo);
        System.out.println("\tWhat can I do for you?");
        printHorizontalLine();
    }

    public static void printHorizontalLine() {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine);
    }

    /**
     * Print exit greetings for the user leaving the program.
     */
    public static void printExitText() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    // Inform user of success in marking task as done

    /**
     * Print exit greetings for the user leaving the program.
     */
    public static void printTaskDoneSuccess(String taskName) {

        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t" + taskName);
    }

    /**
     * Informs user of success in modifying a task's presence in the list.
     *
     * @param taskDescription Description of the task.
     * @param isAddTask Determines whether the task should be added or
     *                  removed from the list.
     */
    public static void modifyTaskSuccess(
            String taskDescription, boolean isAddTask) {
        String action;

        if(isAddTask) {
            action = "added";
        } else {
            action = "removed";
        }

        int maxTask = Task.getNumberOfTasks();

        System.out.println("\t" + "Got it. I've " + action + " this task: ");
        System.out.println("\t\t" + taskDescription);
        System.out.println("\tNow you have "+ maxTask  + " tasks in the list.");
    }

    /**
     * Prints all the tasks whose description matches the search filter given
     * by the user.
     *
     * @param filteredTasks Array of tasks that match search filter.
     * @param searchFilter Filter used to find relevant tasks from current list.
     */
    public static void printMatchingTasks(ArrayList<Task> filteredTasks, String searchFilter) {
        int taskCount = 1;
        System.out.println("\tHere are the tasks that match this command - "+ searchFilter + " :");
        for (Task filteredTask: filteredTasks){
            System.out.println("\t" + taskCount + ". "+ filteredTask.toString());
            taskCount++;
        }
    }

    /**
     * Informs the user that all the tasks in the task list has been cleared.
     */
    public static void clearTaskListSuccess() {
        System.out.println("\t" + "Got it. I've cleared all tasks in the list!");
        System.out.println("\tNow you have no tasks in the list.");
    }
}
