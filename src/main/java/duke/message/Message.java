package duke.message;

import duke.task.Task;

import java.util.ArrayList;

public class Message {
    // Prints the initial greetings when the user loads the program
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

    // Prints a horizontal line
    public static void printHorizontalLine() {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine);
    }

    // Print exit greetings for the user leaving the program
    public static void printExitText() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    // Inform user of success in marking task as done
    public static void printTaskDoneSuccess(String taskName) {

        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t" + taskName);
    }

    // Inform user of success in adding task to list
    public static void modifyTaskSuccess(
            String taskName, boolean isAddTask) {
        String action;

        if(isAddTask) {
            action = "added";
        } else {
            action = "removed";
        }

        int maxTask = Task.getNumberOfTasks();

        System.out.println("\t" + "Got it. I've " + action + " this task: ");
        System.out.println("\t\t" + taskName);
        System.out.println("\tNow you have "+ maxTask  + " tasks in the list.");
    }

    public static void printMatchingTasks(ArrayList<Task> filteredTasks) {
        int taskCount = 1;
        for (Task filteredTask: filteredTasks){
            System.out.println("\t" + taskCount + ". "+ filteredTask.toString());
            taskCount++;
        }
    }
}
