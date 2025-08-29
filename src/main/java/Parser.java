import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {

    private static int parseIndex(String[] arr) {
        return Integer.parseInt(arr[1]) - 1;
    }

    private static String[] requireArgs(String command, String[] args) throws BaymaxException {
        if (args.length < 2) {
            throw new BaymaxException.MissingDescriptionException(command);
        }
        return args;
    }

    public static Command parse(String input) throws BaymaxException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String description;
        String[] str;

        switch (command) {
        case "list":
            return new ListCommand();
        case "mark", "unmark", "delete":
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
        case "bye":
            return new ExitCommand();
        default:
            throw new BaymaxException.InvalidCommandException();
        }
    }
}
