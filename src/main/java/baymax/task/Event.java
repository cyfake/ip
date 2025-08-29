package baymax.task;

public class Event extends Task {
    protected String startTime;
    protected String endTime;

    public Event(boolean isDone, String description, String startTime, String endTime) {
        super(isDone, description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.startTime, this.endTime);
    }

    @Override
    public String toSaveFormat() {
        return String.format("E | %b | %s | %s | %s", this.isDone, this.description, this.startTime, this.endTime);
    }
}
