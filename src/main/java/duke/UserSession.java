package duke;

import duke.data.ReadDataFile;
import duke.data.WriteDataFile;

import duke.exception.IllegalCommandException;
import duke.exception.PartialCommandException;
import duke.exception.RangeExceedException;
import duke.message.Message;
import duke.parser.CommandParser;
import duke.task.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class UserSession {
    // Scanner for user input
    private static final Scanner myScanner = new Scanner(System.in);

    // String Constants

    public static final String ACTION_LIST = "list";
    public static final String ACTION_TODO = "todo";
    public static final String ACTION_EVENT = "event";
    public static final String ACTION_DEADLINE = "deadline";
    public static final String ACTION_EXIT = "bye";

    public UserSession() {
        new ReadDataFile();
        runProgramSequence();
    }

    // Overall structure of a user session
    public void runProgramSequence() {
        String action = "";
        CommandParser newUserCommand;
        Message.printWelcomeText();

        // Ask for new user input until user types an exit command
        do {
            try {
                newUserCommand = new CommandParser();
                action = newUserCommand.getActionCommand();
            } catch (IllegalCommandException e) {
                e.alertException();
            } catch (PartialCommandException p) {
                p.alertException();
            }

        } while (!action.equals(ACTION_EXIT));
        Message.printExitText();
    }

}
