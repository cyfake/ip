package baymax.command;

import baymax.task.TaskList;
import baymax.ui.Ui;

/**
 * Represents a command that lists all tasks currently in the task list.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by displaying the tasks in the task list.
     *
     * @param tasks The task list containing all tasks.
     * @param ui The user interface for displaying the task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.printMsg(tasks.toString());
    }
}
