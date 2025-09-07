package baymax.parser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import baymax.command.AddCommand;
import baymax.command.Command;
import baymax.command.ExitCommand;
import baymax.command.FindCommand;
import baymax.command.ListCommand;
import baymax.command.UpdateCommand;
import baymax.exception.BaymaxException;

/**
 * Parses raw user input into executable {@link Command} objects.
 * <p>
 * The parser interprets text-based commands entered by the user
 * and maps them to the corresponding command classes. It also validates
 * command arguments and throws exceptions for invalid inputs.
 * </p>
 */
public class Parser {

    /**
     * Parses the index argument from a command input.
     *
     * @param arr The array of command tokens.
     * @return The task index.
     * @throws NumberFormatException If the index cannot be parsed as an integer.
     *
     */
    private static int parseIndex(String[] arr) {
        assert arr.length >= 2 : "Index argument missing";
        return Integer.parseInt(arr[1]) - 1;
    }

    /**
     * Ensures that the given command has the required arguments.
     *
     * @param command The command being validated.
     * @param args The command arguments split from the input.
     * @return The same {@code args} array if valid.
     * @throws BaymaxException.MissingDescriptionException If no description is provided.
     */
    private static String[] requireArgs(String command, String[] args) throws BaymaxException {
        if (args.length < 2) {
            throw new BaymaxException.MissingDescriptionException(command);
        }
        return args;
    }

    /**
     * Parses the user input and returns the corresponding {@link Command}.
     *
     * @param input The raw user input string.
     * @return A {@link Command} object that, when executed, performs the action described by the input.
     * @throws BaymaxException If the input is invalid, missing arguments, or contains
     *                         invalid dates or indices.
     */
    public static Command parse(String input) throws BaymaxException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String description;
        String[] str;

        switch (command) {
        case "list":
            return new ListCommand();
        case "mark", "unmark", "delete":
            if (parts.length < 2) {
                throw new BaymaxException.InvalidIndexException();
            }
            return new UpdateCommand(command, parseIndex(parts));
        case "todo":
            description = requireArgs(command, parts)[1];
            return AddCommand.todo(description);
        case "deadline":
            str = requireArgs(command, parts)[1].split(" /by ", 2);

            if (str.length < 2) {
                throw new BaymaxException.MissingDeadlineException();
            }

            description = str[0];
            String date = str[1];

            try {
                LocalDate deadline = LocalDate.parse(date);
                return AddCommand.deadline(description, deadline);
            } catch (DateTimeParseException e) {
                throw new BaymaxException.InvalidDateException();
            }
        case "event":
            str = requireArgs(command, parts)[1].split(" /from | /to ");

            if (str.length < 2) {
                throw new BaymaxException.MissingArgumentsException();
            }

            description = str[0];
            String start = str[1];
            String end = str[2];

            return AddCommand.event(description, start, end);
        case "find":
            String keyword = requireArgs(command, parts)[1];
            return new FindCommand(keyword);
        case "bye":
            return new ExitCommand();
        default:
            throw new BaymaxException.InvalidCommandException();
        }
    }
}
