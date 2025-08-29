package baymax.ui;

import java.util.Scanner;

public class Ui {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────────────────";
    private Scanner sc = new Scanner(System.in);

    private void printLine() {
        System.out.println("\t" + HORIZONTAL);
    }

    public void printMsg(String msg) {
        printLine();
        System.out.println("\t" + msg);
        printLine();
    }

    public void greet() {
        printMsg("""
                Hello! I am Baymax, your personal chatbot companion.
                \tI am here to help.""");
    }

    public void bye() {
        sc.close();
        printMsg("I will deactivate now. I hope you are satisfied with my care.");
    }

    public String read() {
        return sc.nextLine();
    }
}
