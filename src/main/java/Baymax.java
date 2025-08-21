import java.util.ArrayList;
import java.util.Scanner;

public class Baymax {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────";
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    private static void printLine() {
        System.out.println("\t" + HORIZONTAL);
    }

    private static void printMsg(String msg) {
        printLine();
        System.out.println("\t" + msg);
        printLine();
    }

    private static void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        printMsg("added: " + description);
    }

    private static void printTasks() {
        printLine();
        System.out.println("\tHere are the tasks in your list: ");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("\t%d. %s\n", i + 1, tasks.get(i).getTask());
        }
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
                    printTasks();
                    break;
                case "mark":
                    index =  Integer.parseInt(parts[1]);
                    Task taskMark = tasks.get(index - 1);
                    taskMark.mark();

                    printMsg("""
                            Nice! I've marked this task as done:
                            \t""" + taskMark.getTask());
                    break;
                case "unmark":
                    index =  Integer.parseInt(parts[1]);
                    Task taskUnmark = tasks.get(index - 1);
                    taskUnmark.unmark();
                    printMsg("""
                            OK, I've marked this task as not done yet:
                            \t""" + taskUnmark.getTask());
                    break;
                default:
                    addTask(input);
            }
            input = scanner.nextLine();
            parts = input.split(" ",2);

            command = parts[0];
        }

        printMsg("I will deactivate now.");
    }
}