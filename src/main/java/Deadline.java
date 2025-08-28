import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate deadline;

    public Deadline(boolean isDone, String description, LocalDate deadline) {
        super(isDone, description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        String formattedDeadline = deadline.format(formatter);
        return String.format("[D]%s (by: %s)", super.toString(), formattedDeadline);
    }

    @Override
    public String toSaveFormat() {
        return String.format("D | %b | %s | %s", this.isDone, this.description, this.deadline);
    }
}
