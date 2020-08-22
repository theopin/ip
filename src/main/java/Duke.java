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
            insertTask(userCommand);
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

    // Insert a new task into the list of tasks
    public static void insertTask(String newTask) {
        int new_index = Task.getNumberOfTasks();
        tasks[new_index]= new Task(newTask);
        System.out.println("\t" + "added: " + newTask);
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
        System.out.println("\t[" + (tasks[index].getStatusIcon() + "] ")
                + tasks[index].getDescription());
    }

    // Prints the whole list of tasks
    public static void printTaskList() {
        System.out.println("\tHere are the tasks in your list:");

        // Print each task based on a specified format
        int iterations = Task.getNumberOfTasks();
        for (int i = 0; i < iterations; i++) {
            System.out.println("\t" +(i+1) + ".[" + (tasks[i].getStatusIcon() + "] ")
                    + tasks[i].getDescription());
        }
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
