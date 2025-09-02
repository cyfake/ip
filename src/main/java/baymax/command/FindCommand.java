package baymax.command;

import baymax.task.TaskList;
import baymax.ui.Ui;

/**
 * Represents a command that searches the task list for tasks
 * containing a specified keyword in their description.
 */
public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by scanning the task list for matches
     * and printing the results through the user interface.
     *
     * @param tasks The task list to search through.
     * @param ui The user interface for displaying matching tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.printMsg(tasks.find(this.keyword));
    }
}
