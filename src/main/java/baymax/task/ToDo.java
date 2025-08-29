package baymax.task;

public class ToDo extends Task {
    public ToDo(boolean isDone, String description) {
        super(isDone, description);
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }

    @Override
    public String toSaveFormat() {
        return String.format("T | %b | %s", this.isDone, this.description);
    }
}
