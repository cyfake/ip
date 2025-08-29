import java.io.IOException;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.printMsg(tasks.toString());
    }
}
