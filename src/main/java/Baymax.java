import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Baymax {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Baymax(String filePath) {
        this.storage = new Storage(filePath);
        this.tasks = new TaskList();
        this.ui = new Ui();

        try {
            tasks = storage.load();
        } catch (IOException e) {
            ui.printMsg("Error loading tasks: " + e.getMessage());
        }
    }

    public void run() {
        this.ui.greet();

        boolean isExit = false;

        while (!isExit) {
            try {
                Command command = Parser.parse(ui.read());
                command.execute(tasks, ui);
                isExit = command.isExit();
            } catch (BaymaxException e) {
                ui.printMsg(e.getMessage());
            } catch (NumberFormatException e) {
                ui.printMsg("Hmm… that does not appear to be a valid task number. " +
                        "Please provide a whole number so I may help you.");
            }

            try {
                storage.save(tasks);
            } catch (IOException e) {
                ui.printMsg("Error saving tasks: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Baymax("./data/Baymax.txt").run();
    }
}