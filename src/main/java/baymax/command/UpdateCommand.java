package baymax.command;

import baymax.exception.BaymaxException;
import baymax.task.TaskList;
import baymax.ui.Ui;

/**
 * Represents a command that updates an existing task in the task list.
 * <p>
 * The update can be one of the following actions:
 * <ul>
 *   <li>mark — mark a task as completed</li>
 *   <li>unmark — unmark a completed task</li>
 *   <li>delete — remove a task from the list</li>
 * </ul>
 * </p>
 */
public class UpdateCommand extends Command {

    private String type;
    private int index;

    public UpdateCommand(String action, int index) {
        this.type = action;
        this.index = index;
    }

    /**
     * Executes the update command by performing the specified action
     * on the task at the given index.
     *
     * @param tasks The task list containing all tasks.
     * @param ui The user interface for displaying the result of the update.
     * @throws BaymaxException If the index is invalid or the update cannot be performed.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) throws BaymaxException {
        switch (type) {
        case "mark":
            ui.printMsg(tasks.mark(index));
            break;
        case "unmark":
            ui.printMsg(tasks.unmark(index));
            break;
        case "delete":
            ui.printMsg(tasks.delete(index));
            break;
        }
    }
}
