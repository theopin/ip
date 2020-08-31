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

    // Task array
    public static final int MAX_TASKS = 100;
    public static Task[] tasks = new Task[MAX_TASKS];

    public UserSession() {
        runProgramSequence();
    }

    // Overall structure of a user session
    public void runProgramSequence() {
        String action;
        printWelcomeText();

        // Ask for new user input until user types an exit command
        do {
           String[] userInput = receiveUserInput();
           userInput[0] = userInput[0].toLowerCase();
           parseUserInput(userInput);

           action = userInput[0];
        } while(!action.equals(ACTION_EXIT));
        printExitText();
    }

    // Prints the initial greetings when the user loads the program
    public void printWelcomeText() {
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

    // Takes in input from the user
    public String[] receiveUserInput() {
        String userCommand = myScanner.nextLine().trim();
        printHorizontalLine();
        return userCommand.split(WHITESPACE);
    }

    // Deciphers the action to be done based on the input
    public void parseUserInput(String [] userInput) {
        String action = userInput[0];

        // Run the respective methods based on the action
        switch(action) {
        case ACTION_DONE:
            setTaskAsComplete(userInput[1]);
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
        default:
            break;
        }
    }

    // Sets the particular task as done
    public static void setTaskAsComplete(String taskNumber) {
        int index = Integer.parseInt(taskNumber) - 1;
        tasks[index].markAsDone(true);

        // Inform user of success operation
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t" + tasks[index].toString());
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
        System.out.println("\t" + "Got it. I've added this task: ");
        System.out.println("\t\t" + tasks[new_index].toString());
        System.out.println("\tNow you have "+ (new_index + 1)  + " tasks in the list.");
    }

    // Prints a horizontal line
    public void printHorizontalLine() {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine);
    }

    // Print exit greetings for the user leaving the program
    public void printExitText() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }
}
