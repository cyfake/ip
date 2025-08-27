import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            return new TaskList();
        }

        TaskList tasks = new TaskList();
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            tasks.addTask(Task.toTaskFormat(sc.nextLine()));
        }

        sc.close();

        return tasks;
    }

    public void save(TaskList tasks) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        for (Task task : tasks.getAll()) {
            writer.write(task.toSaveFormat() + "\n");
        }

        writer.close();
    }
}
