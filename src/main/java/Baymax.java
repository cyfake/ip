import java.util.ArrayList;
import java.util.Scanner;

public class Baymax {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────";
    private static ArrayList<String> tasks = new ArrayList<String>();

    private static void printLine() {
        System.out.println("\t" + HORIZONTAL);
    }

    private static void printMsg(String msg) {
        printLine();
        System.out.println("\t" + msg);
        printLine();
    }

    private static void addTask(String task) {
        tasks.add(task);
        printMsg("added: " + task);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMsg("""
                Hello! I am Baymax, your personal chatbot companion.
                \tI am here to help.""");

        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            addTask(input);
            input = scanner.nextLine();
        }

        printMsg("I will deactivate now.");
    }
}