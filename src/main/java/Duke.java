import java.util.Scanner;

public class Duke {
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


        if (!userCommand.equals("bye")) {
            System.out.println("\t" + userCommand);
            printHorizontalLine();
            return false;
        }
        return true;
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
