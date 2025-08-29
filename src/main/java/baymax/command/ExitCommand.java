package baymax.command;

import baymax.task.TaskList;

import baymax.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.bye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
