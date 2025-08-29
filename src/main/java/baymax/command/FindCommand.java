package baymax.command;

import baymax.task.TaskList;

import baymax.ui.Ui;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.printMsg(tasks.find(this.keyword));
    }
}
