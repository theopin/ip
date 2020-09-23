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
    private static final String[] taskRelatedCommand = {ACTION_DONE, ACTION_REMOVE, ACTION_FIND};
    private static final String[] standaloneCommand = {ACTION_EXIT, ACTION_LIST};

    private String actionCommand = "";

    public CommandParser() {
        requestUserInput();
    }

    /**
     * Takes in a command given by the user.
     */
    public void requestUserInput()  {
        String[] userInput;
        try {
            userInput = receiveUserInput();
            userInput[0] = userInput[0].toLowerCase();
            new TaskHandler(userInput);
            setActionCommand(userInput[0]);
        } catch (IllegalCommandException e) {
            e.alertException();
        } catch (PartialCommandException p) {
            p.alertException();
        }
    }

    /**
     * Writes the values of textContent into duke.txt.
     *
     * @throws IllegalCommandException Thrown if the user command does not match any
     *                                 predefined action.
     * @throws PartialCommandException Thrown if the user command is incomplete.
     */
    public String[] receiveUserInput() throws IllegalCommandException, PartialCommandException {
        String userCommand = myScanner.nextLine().trim();
        Message.printHorizontalLine();
        String[] splitCommand = userCommand.split(WHITESPACE);

        if (!(Arrays.asList(standaloneCommand).contains(splitCommand[0]))) {
            if (!Arrays.asList(taskTypes).contains(splitCommand[0])
                && !Arrays.asList(taskRelatedCommand).contains(splitCommand[0])) {
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
