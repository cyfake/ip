package baymax.command;

import baymax.exception.BaymaxException;

import baymax.task.TaskList;

import baymax.ui.Ui;

/**
 * Represents a user command that can be executed in the Baymax application.
 */
public abstract class Command {
    /**
     * Executes the command using the provided task list and user interface.
     *
     * @param tasks The {@link TaskList} containing the user's tasks.
     * @param ui The {@link Ui} for displaying output messages to the user.
     * @throws BaymaxException If the command cannot be executed successfully.
     */
    public abstract void execute(TaskList tasks, Ui ui) throws BaymaxException;

    /**
     * Determines whether this command should terminate the program.
     *
     * @return {@code true} if this command terminates the program, {@code false} otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
