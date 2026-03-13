import java.util.Arrays;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks;  // вот эта сучья строка не работала и я всю голову сломал почему.
        // удалил и заново перенабрал - заработала.... но! 4 часа на поиск решения проблемы, которой даже не было

        //    this.subtasks = Arrays.copyOf(subtasks, subtasks.length); // заполнение своих полей
    }

    public String[] getSubtasks() {
        return Arrays.copyOf(subtasks, subtasks.length);
    }


    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;

    }
}
