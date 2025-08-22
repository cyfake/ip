import java.util.Scanner;

public class Baymax {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────";
    private static TaskList tasks = new TaskList();

    private static void printLine() {
        System.out.println("\t" + HORIZONTAL);
    }

    private static void printMsg(String msg) {
        printLine();
        System.out.println("\t" + msg);
        printLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMsg("""
                Hello! I am Baymax, your personal chatbot companion.
                \tI am here to help.""");

        String input = scanner.nextLine();
        String[] parts = input.split(" ", 2);

        String command = parts[0];
        int index;
        String description;
        String[] str;

        while (!command.equals("bye")) {

            try {
                switch (command) {
                    case "list":
                        printMsg(tasks.toString());
                        break;
                    case "mark":
                        index = Integer.parseInt(parts[1]) - 1;
                        printMsg(tasks.mark(index));
                        break;
                    case "unmark":
                        index = Integer.parseInt(parts[1]) - 1;
                        printMsg(tasks.unmark(index));
                        break;
                    case "todo":
                        if (parts.length < 2) {
                            throw new BaymaxException.MissingDescriptionException(command);
                        }
                        description = parts[1];
                        printMsg(tasks.addTask(new ToDo(description)));
                        break;
                    case "deadline":
                        if (parts.length < 2) {
                            throw new BaymaxException.MissingDescriptionException(command);
                        }
                        str = parts[1].split(" /by ", 2);
                        if (str.length < 2) {
                            throw new BaymaxException.MissingDeadlineException();
                        }
                        description = str[0];
                        String deadline = str[1];
                        printMsg(tasks.addTask(new Deadline(description, deadline)));
                        break;
                    case "event":
                        if (parts.length < 2) {
                            throw new BaymaxException.MissingDescriptionException(command);
                        }
                        str = parts[1].split(" /from | /to ");
                        if (str.length < 2) {
                            throw new BaymaxException.MissingArgumentsException();
                        }
                        description = str[0];
                        String start = str[1];
                        String end = str[2];
                        printMsg(tasks.addTask(new Event(description, start, end)));
                        break;
                    default:
                        throw new BaymaxException.InvalidCommandException();
                }
            } catch (BaymaxException e) {
                printMsg(e.getMessage());
            } catch (NumberFormatException e) {
                printMsg("Hmm… that does not appear to be a valid task number. " +
                         "Please provide a whole number so I may help you.");
            }

            input = scanner.nextLine();
            parts = input.split(" ",2);
            command = parts[0];
        }

        printMsg("I will deactivate now. " +
                "I hope you are satisfied with my care.");
    }
}