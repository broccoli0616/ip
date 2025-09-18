package Broccoli;

import Broccoli.Tasks.Task;

import java.util.Scanner;
import Broccoli.Command.*;

/**
 * Handles parsing and processing of user input commands.
 * Coordinates between userInterface and task storage operations.
 */
public class Parser {
    private Storage storage;
    private Scanner scanner;
    private Ui userInterface;

    public Parser(Storage storage, Ui userInterface, Scanner scanner) {
        assert storage != null : "Storage cannot be null";
        assert userInterface != null : "User interface cannot be null";
        assert scanner != null : "Scanner cannot be null";
        this.storage = storage;
        this.userInterface = userInterface;
        this.scanner = scanner;
    }


    /**
     * Processes user input commands in a continuous loop until exit.
     * Handles commands like list, mark, unmark, delete, and task addition.
     *
     * @param taskList The task list to operate on.
     */
    public String processCommand(String userInput, TaskList taskList) {

        String input = userInput.trim();
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1].trim() : "";
        try {
            switch (command.toLowerCase()) {
            case "bye":
                return userInterface.exiting();
            case "list":
                return userInterface.displayList(taskList);
            case "help":
                return userInterface.displayHelpMessage();
            case "mark":
                validateArgument(argument, "mark");
                return new MarkCommand(Integer.parseInt(argument)).execute(taskList, userInterface, storage);
            case "unmark":
                validateArgument(argument, "unmark");
                return new UnmarkCommand(Integer.parseInt(argument)).execute(taskList, userInterface, storage);
            case "delete":
                validateArgument(argument, "delete");
                return new DeleteCommand(Integer.parseInt(argument)).execute(taskList, userInterface, storage);
            case "find":
                validateArgument(argument, "find");
                return new FindCommand(argument).execute(taskList, userInterface, storage);
            default:
                if (!input.isEmpty()) {
                    return new AddCommand(input).execute(taskList, userInterface, storage);
                } else {
                    throw new IllegalArgumentException("Please do not give me any empty command");
                }
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private void validateArgument(String argument, String description) {
        if (argument.isEmpty()) {
            throw new IllegalArgumentException("Please specify the task number to " + description +".");
        }
    }
}

