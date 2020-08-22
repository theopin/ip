import java.util.Scanner;

public class Duke {
    static Task[] tasks = new Task[100];


    public static void main(String[] args) {
        boolean isExit;
        printWelcomeText();

        do {
            isExit = insertCommand();
        } while(!isExit);

        printExitText();
    }

    public static void printWelcomeText() {
        printHorizontalLine();
        String logo = "\t ____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\tHello from\n" + logo);
        System.out.println("\tWhat can I do for you?");
        printHorizontalLine();
    }

    public static boolean insertCommand() {
        String userCommand;
        Scanner myCommand = new Scanner(System.in);
        userCommand = myCommand.nextLine().trim();

        String userAction = filterUserAction(userCommand);
        printHorizontalLine();

        switch (userAction) {
        case "bye":
            return true;
        case "list":
            printTaskList();
            break;
        case "done":
            int taskIndex = extractTaskIndex(userCommand, userAction);
            setTaskAsComplete(taskIndex);
            break;
        default:
            insertTask(userCommand);
            break;
        }

        printHorizontalLine();
        return false;
    }

    public static String filterUserAction(String userCommand) {
        String newAction = userCommand.toLowerCase();

        if(newAction.contains(" ")) {
            newAction = newAction.substring(0, newAction.indexOf(" "));
        }

        return newAction;
    }

    public static void insertTask(String newTask) {
        int new_index = Task.getNumberOfTasks();
        tasks[new_index]= new Task(newTask);
        System.out.println("\t" + "added: " + newTask);
    }

    public static int extractTaskIndex(String userCommand, String userAction) {
        int userActionWordLength = userAction.length();
        String taskIndex = userCommand.substring(userActionWordLength).trim();
        return Integer.parseInt(taskIndex);
    }

    public static void setTaskAsComplete(int index) {
        index--;
        tasks[index].setIsDone(true);

        System.out.println("\tNice! I've marked this task as done:");
        System.out.print("\t[" + tasks[index].getStatusIcon() + "] ");
        System.out.println(tasks[index].getDescription());
    }

    public static void printTaskList() {
        int iterations = Task.getNumberOfTasks();
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < iterations; i++) {
            System.out.print("\t" +(i+1) + ".[" + tasks[i].getStatusIcon() + "] ");
            System.out.println(tasks[i].getDescription());
        }
    }

    public static void printExitText() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void printHorizontalLine() {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine);
    }
}
