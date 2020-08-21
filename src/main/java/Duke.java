public class Duke {
    public static void main(String[] args) {
        printWelcomeText();
        printExitText();
    }

    public static void printWelcomeText() {
        printHorizontalLine();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(" Hello from\n" + logo);
        System.out.println(" What can I do for you?");
    }

    public static void printExitText() {
        printHorizontalLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void printHorizontalLine() {
        String horizontalLine = "____________________________________________________________";
        System.out.println(horizontalLine);
    }
}
