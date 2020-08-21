import java.util.Scanner;

public class Duke {
    static String[] tasks = new String[100];
    static int numberOfTasks = 0;

    public static void main(String[] args) {
        boolean isExit = false;
        printWelcomeText();

        do {
            isExit = insertCommand();
        }
        while(!isExit);

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
        userCommand = myCommand.nextLine();
        printHorizontalLine();


        if (userCommand.equals("bye")) {
            return true;
        }
        else if(userCommand.equals("list")) {
            printTaskList();
        }
        else {
            insertTask(userCommand);
        }
        printHorizontalLine();
        return false;
    }

    public static void insertTask(String newTask) {
        tasks[numberOfTasks] = newTask;
        numberOfTasks++;
        System.out.println("\t" + "added: " + newTask);
    }

    public static void printTaskList() {
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("\t" +(i+1) + ". " + tasks[i]);
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
