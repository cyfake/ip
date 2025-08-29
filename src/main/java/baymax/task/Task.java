package baymax.task;

import java.time.LocalDate;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(boolean isDone, String description) {
        this.isDone = isDone;
        this.description = description;
    }

    public String getStatus() {
        return this.isDone ? "X" : " ";
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatus(), this.description);
    }

    public String mark() {
        this.isDone = true;

        return """
                Task complete. You are doing a wonderful job.
                \t""" + this;
    }

    public String unmark() {
        this.isDone = false;

        return """
                I have unmarked this task.
                \t""" + this;
    }

    public static Task toTaskFormat(String line) {
        String[] parts = line.split(" \\| ");

        String taskType = parts[0];
        boolean isDone = Boolean.parseBoolean(parts[1]);
        String description = parts[2];

        return switch (taskType) {
            case "T":
                yield new ToDo(isDone, description);
            case "D":
                LocalDate deadline = LocalDate.parse(parts[3]);
                yield new Deadline(isDone, description, deadline);
            case "E":
                String startTime = parts[3];
                String endTime = parts[4];
                yield new Event(isDone, description, startTime, endTime);
            default:
                yield new ToDo(false, "test");
        };
    }

    public abstract String toSaveFormat();
}
