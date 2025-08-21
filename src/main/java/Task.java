public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatus() {
        return this.isDone ? "X" : " ";
    }

    public String getTask() {
        return String.format("[%s] %s", this.getStatus(), this.description);
    }

    public String mark() {
        this.isDone = true;

        return """
                Task complete. You are doing a wonderful job.
                \t""" + this.getTask();
    }

    public String unmark() {
        this.isDone = false;

        return """
                I have unmarked this task.
                \t""" + this.getTask();
    }
}
