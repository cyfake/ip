import java.util.Scanner;

public class Baymax {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────";

    private static void printLine() {
        System.out.println("\t" + HORIZONTAL);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printLine();
        System.out.println("""
                \tHello! I am Baymax, your personal chatbot companion.
                \tI am here to help.""");
        printLine();

        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            printLine();
            System.out.println("\t" + input);
            printLine();
            input = scanner.nextLine();
        }

        printLine();
        System.out.println("\tI will deactivate now.");
        printLine();
    }
}