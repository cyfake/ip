public class UpdateCommand extends Command {

    private String type;
    private int index;

    public UpdateCommand(String action, int index) {
        this.type = action;
        this.index = index;
    }
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
