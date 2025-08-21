public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
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
}
