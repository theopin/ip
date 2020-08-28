import java.util.Scanner;

public class Duke {
    public static Task[] tasks = new Task[100];

    // Main Function
    public static void main(String[] args) {
        boolean isExit;
        printWelcomeText();

        // Ask for new user input until user types an exit command
        do {
            isExit = insertCommand();
        } while(!isExit);

        printExitText();
    }

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

    // Takes the user's command, extracts and performs action specified
    public static boolean insertCommand() {
        // Take in input from user and trim any empty spaces
        String userCommand;
        Scanner myCommand = new Scanner(System.in);
        userCommand = myCommand.nextLine().trim();

        // Filter out action and print a horizontal line
        String userAction = filterUserAction(userCommand);
        printHorizontalLine();

        // Match the action with the following cases
        switch (userAction) {
        case "bye":
            // Update isExit in main() as true to exit program
            return true;

        case "list":
            printTaskList();
            break;

        case "done":
            // Find index of the task to be set, then use it to access particular task
            int taskIndex = extractTaskIndex(userCommand, userAction);
            setTaskAsComplete(taskIndex);
            break;

        default:
            // Default setting is to insert command as a new task
            insertTask(userCommand.substring(userAction.length()), userAction);
            break;
        }

        // Print a horizontal line and update isExit in main() as false to repeat insertCommand
        printHorizontalLine();
        return false;
    }
    // Returns the action extracted from the user input
    public static String filterUserAction(String userCommand) {
        String newAction = userCommand.toLowerCase();

        // Extracts first word of strings with multiple words
        if(newAction.contains(" ")) {
            newAction = newAction.substring(0, newAction.indexOf(" "));
        }

        return newAction;
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

    // Returns the index of the task to be modified
    public static int extractTaskIndex(String userCommand, String userAction) {
        int userActionWordLength = userAction.length();
        String taskIndex = userCommand.substring(userActionWordLength).trim();
        return Integer.parseInt(taskIndex);
    }

    // Sets the particular task as done
    public static void setTaskAsComplete(int index) {
        index--;
        tasks[index].markAsDone(true);

        // Task has been updated successfully
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t" + tasks[index].toString());
    }

    // Insert a new task into the list of tasks
    public static void insertTask(String newTask, String type) {
        final String TODO = "todo";
        final String EVENT = "event";
        final String DEADLINE = "deadline";

        int new_index = Task.getNumberOfTasks();
        String taskName = newTask;

        if(newTask.contains("/")) {
            taskName = newTask.substring(0, newTask.indexOf("/") - 1).trim();
        }

        switch(type) {
        case TODO:
            tasks[new_index] = new Todo(newTask);
            break;
        case EVENT:
            String allocatedTime = splitTaskDetails(newTask);
            tasks[new_index] = new Event(taskName, allocatedTime);
            break;
        case DEADLINE:
            String dueDate = splitTaskDetails(newTask);
            tasks[new_index] = new Deadline(taskName, dueDate);
            break;
        default:
            tasks[new_index] = new Task(newTask);

        }
        System.out.println("\t" + "Got it. I've added this task: ");
        System.out.println("\t\t" + tasks[new_index].toString());
        System.out.println("\tNow you have "+ (new_index + 1)  + " tasks in the list.");
    }

    public static String splitTaskDetails(String newTask) {
        String extraDetails = "undefined";

        if(newTask.contains("/")) {
            extraDetails = newTask.substring(newTask.indexOf("/") + 4);
        }
        return extraDetails;
    }
    // Print exit greetings for the user leaving the program
    public static void printExitText() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    // Prints a horizontal line
    public static void printHorizontalLine() {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine);
    }
}
