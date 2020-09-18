package duke;

import duke.data.ReadDataFile;
import duke.data.WriteDataFile;

import duke.exception.IllegalCommandException;
import duke.exception.PartialCommandException;
import duke.exception.RangeExceedException;
import duke.message.Message;
import duke.task.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class UserSession {
    // Scanner for user input
    private static final Scanner myScanner = new Scanner(System.in);

    // String Constants

    public static final String ACTION_LIST = "list";
    public static final String ACTION_DONE = "done";
    public static final String ACTION_TODO = "todo";
    public static final String ACTION_EVENT = "event";
    public static final String ACTION_DEADLINE = "deadline";
    public static final String ACTION_EXIT = "bye";
    public static final String ACTION_REMOVE = "remove";
    public static final String WHITESPACE = " ";

    private static final String[] taskTypes = {ACTION_TODO, ACTION_EVENT, ACTION_DEADLINE};
    private static final String[] standaloneCommand = {ACTION_EXIT, ACTION_LIST};

    //public static ArrayList<Task> tasks = new ArrayList<>();

    public UserSession() {
        new ReadDataFile();
        runProgramSequence();
    }

    // Overall structure of a user session
    public void runProgramSequence() {
        String action = "";
        Message.printWelcomeText();

        // Ask for new user input until user types an exit command
        do {
            try {
                action = requestUserInput();
            } catch (IllegalCommandException e) {
                e.alertException();
            } catch (PartialCommandException p) {
                p.alertException();
            }

        } while (!action.equals(ACTION_EXIT));
        Message.printExitText();
    }

    public String requestUserInput() throws IllegalCommandException, PartialCommandException {
        String[] userInput = receiveUserInput();
        userInput[0] = userInput[0].toLowerCase();
        new TaskHandler(userInput);
        //new TaskHandler
        return userInput[0];
    }

    // Takes in input from the user
    public String[] receiveUserInput() throws IllegalCommandException, PartialCommandException {
        String userCommand = myScanner.nextLine().trim();
        Message.printHorizontalLine();
        String[] splitCommand = userCommand.split(WHITESPACE);

        if (!(Arrays.asList(standaloneCommand).contains(splitCommand[0]))) {
            if (Arrays.asList(taskTypes).contains(splitCommand[0])) {
                throw new PartialCommandException(splitCommand[0]);
            } else {
                throw new IllegalCommandException();
            }
        }
        return splitCommand;
    }

}


