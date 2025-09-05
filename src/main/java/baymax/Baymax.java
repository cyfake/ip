package baymax;

import java.io.IOException;

import baymax.command.Command;
import baymax.exception.BaymaxException;
import baymax.parser.Parser;
import baymax.storage.Storage;
import baymax.task.TaskList;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.util.Duration;

public class Baymax {
    private Storage storage;
    private TaskList tasks;

    public Baymax(String filePath) {
        this.storage = new Storage(filePath);
        this.tasks = new TaskList();
    }

    public void start() throws IOException {
        tasks = storage.load();
    }

    /**
     * Generates a response for the user's message.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);

            if (command.isExit()) {
                PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
                delay.setOnFinished(event -> Platform.exit());
                delay.play();
            }

            try {
                storage.save(tasks);
            } catch (IOException e) {
                return "Error saving tasks: " + e.getMessage();
            }
            return command.execute(tasks);
        } catch (BaymaxException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return "Hmm… that does not appear to be a valid task number. "
                    + "Please provide a whole number so I may help you.";
        }
    }
}
