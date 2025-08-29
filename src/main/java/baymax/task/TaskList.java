package baymax.task;

import java.util.ArrayList;

import baymax.exception.BaymaxException;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getAll() {
        return tasks;
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
                \tLet’s take care of them together:""");

        for (int i = 0; i < tasks.size(); i++) {
            str.append("\n\t%d. %s".formatted(i + 1, tasks.get(i)));
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

    public String delete(int index) throws BaymaxException.InvalidIndexException {
        if (index < 0 || index >= tasks.size()) {
            throw new BaymaxException.InvalidIndexException(index);
        }

        Task task = tasks.get(index);
        tasks.remove(index);

        return String.format("""
                        Noted. I've removed this task:
                        \t\t %s
                        \tNow you have %d tasks in the list.""",
                task,
                this.tasks.size());
    }

    public String find(String keyword) {
        StringBuilder str = new StringBuilder("""
                I have scanned your list and found these tasks for you:""");

        int count = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            if (task.description.contains(keyword)) {
                str.append("\n\t%d. %s".formatted(count + 1, task));
                count++;
            }
        }

        if (count == 0) {
            return """
                I scanned your list thoroughly, but I could not find any tasks matching your request.
                \tDo not worry, I am still here to assist you.""";
        }

        return str.toString();
    }
}
