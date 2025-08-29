package baymax.command;

import baymax.exception.BaymaxException;

import baymax.task.TaskList;

import baymax.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui) throws BaymaxException;

    public boolean isExit() {
        return false;
    }
}
