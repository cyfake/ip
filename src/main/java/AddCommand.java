import java.time.LocalDate;

public class AddCommand extends Command {

    private Task task;

    private AddCommand(Task task) {
        this.task = task;
    }

    public static AddCommand todo(String description) {
        return new AddCommand(new ToDo(false, description));
    }

    public static AddCommand deadline(String description, LocalDate deadline) {
        return new AddCommand(new Deadline(false, description, deadline));
    }

    public static AddCommand event(String description, String start, String end) {
        return new AddCommand(new Event(false, description, start, end));
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.printMsg(tasks.addTask(this.task));
    }
}
