import java.util.Arrays;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = Arrays.copyOf(subtasks, subtasks.length); // заполнение своих полей
    }

    public String[] getSubtasks() {
        return  Arrays.copyOf(subtasks, subtasks.length);
    }
}
