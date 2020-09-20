package duke.parser;

import duke.exception.IllegalCommandException;
import duke.exception.PartialCommandException;
import duke.message.Message;
import duke.task.TaskHandler;

import java.util.Arrays;
import java.util.Scanner;


import static duke.task.TaskHandler.*;


public class CommandParser {
    // Scanner for user input
    private static final Scanner myScanner = new Scanner(System.in);

    public static final String WHITESPACE = " ";

    private static final String[] taskTypes = {ACTION_TODO, ACTION_EVENT, ACTION_DEADLINE};
    private static final String[] markTaskTypes = {ACTION_DONE, ACTION_REMOVE};
    private static final String[] standaloneCommand = {ACTION_EXIT, ACTION_LIST};

    private String actionCommand;

    public CommandParser() throws IllegalCommandException, PartialCommandException {
        requestUserInput();
    }

    public void requestUserInput() throws IllegalCommandException, PartialCommandException {
        String[] userInput = receiveUserInput();
        userInput[0] = userInput[0].toLowerCase();
        new TaskHandler(userInput);
        setActionCommand(userInput[0]);
    }

    // Takes in input from the user
    public String[] receiveUserInput() throws IllegalCommandException, PartialCommandException {
        String userCommand = myScanner.nextLine().trim();
        Message.printHorizontalLine();
        String[] splitCommand = userCommand.split(WHITESPACE);

        if (!(Arrays.asList(standaloneCommand).contains(splitCommand[0]))) {
            if (!Arrays.asList(taskTypes).contains(splitCommand[0])
                && !Arrays.asList(markTaskTypes).contains(splitCommand[0])) {
                throw new IllegalCommandException();
            }

            if(splitCommand.length <= 1) {
                throw new PartialCommandException(splitCommand[0]);
            }
        }
        return splitCommand;
    }

    public void setActionCommand(String actionCommand) {
        this.actionCommand = actionCommand;
    }

    public String getActionCommand() {
        return actionCommand;
    }
}
