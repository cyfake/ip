public class Deadline extends Task {
    protected String deadline;

    public Deadline(boolean isDone, String description, String deadline) {
        super(isDone, description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), deadline);
    }

    @Override
    public String toSaveFormat() {
        return String.format("D | %b | %s | %s", this.isDone, this.description, this.deadline);
    }
}
