import java.util.ArrayList;
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

        while (!command.equals("bye")) {
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
                default:
                    printMsg(tasks.addTask(new ToDo(input)));
            }
            input = scanner.nextLine();
            parts = input.split(" ",2);

            command = parts[0];
        }

        printMsg("I will deactivate now. " +
                "I hope you are satisfied with my care.");
    }
}