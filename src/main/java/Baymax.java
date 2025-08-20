public class Baymax {
    private static final String HORIZONTAL = "────────────────────────────────────────────────────────────";

    private static void printLine() {
        System.out.println(HORIZONTAL);
    }

    public static void main(String[] args) {
        printLine();
        System.out.println("""
                Hello! I am Baymax, your personal chatbot companion.
                I am here to help.""");
        printLine();
        System.out.println("I will deactivate now.");
        printLine();
    }
}