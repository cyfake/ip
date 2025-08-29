package baymax.command;

import baymax.task.TaskList;

import baymax.ui.Ui;

/**
 * Represents a command that terminates the Baymax chatbot.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by displaying a farewell message.
     *
     * @param tasks The task list (not used in this command).
     * @param ui The user interface for displaying the farewell message.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.bye();
    }

    /**
     * Indicates that this command will terminate the program.
     *
     * @return {@code true}, since this command exits the program.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
