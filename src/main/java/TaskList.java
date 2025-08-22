import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public String addTask(Task task) {
        this.tasks.add(task);
        return String.format("""
                Got it. I've added this task:
                \t\t%s
                \tNow you have %d tasks in the list.""",
                task,
                tasks.size());

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("""
                Here are the tasks I found in your list.
                \tLet’s take care of them together:\n""");

        for (int i = 0; i < tasks.size(); i++) {
            str.append("\t%d. %s\n".formatted(i + 1, tasks.get(i)));
        }

        return str.toString();
    }

    public String mark(int index) throws BaymaxException.InvalidIndexException {
        if (index < 0 || index >= tasks.size()) {
            throw new BaymaxException.InvalidIndexException(index);
        }
        return this.tasks.get(index).mark();
    }

    public String unmark(int index) throws BaymaxException.InvalidIndexException {
        if (index < 0 || index >= tasks.size()) {
            throw new BaymaxException.InvalidIndexException(index);
        }
        return this.tasks.get(index).unmark();
    }
}
