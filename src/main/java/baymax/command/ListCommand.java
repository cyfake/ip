package baymax.command;

import baymax.task.TaskList;

import baymax.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.printMsg(tasks.toString());
    }
}
