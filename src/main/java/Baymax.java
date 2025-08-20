import java.util.Scanner;

public class Baymax {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────";

    private static void printLine() {
        System.out.println(HORIZONTAL);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printLine();
        System.out.println("""
                Hello! I am Baymax, your personal chatbot companion.
                I am here to help.""");
        printLine();

        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            printLine();
            System.out.println(input);
            printLine();
            input = scanner.nextLine();
        }

        System.out.println("I will deactivate now.");
        printLine();
    }
}