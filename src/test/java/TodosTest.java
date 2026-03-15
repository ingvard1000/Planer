import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    //*****************************
    @Test
    public void QuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Позвонить родителям";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void QueryTwoSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask1 = new SimpleTask(3, "Записаться на секцию");
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask1);

        String query = "Записаться на секцию";

        Task[] expected = {simpleTask1};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void QueryNothingSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Набрать клинта";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    //************************************
    @Test
    public void QueryMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Выкатка 3й версии приложения";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void QueryTwoMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting1 = new Meeting(
                111,
                "Накатить по второй",
                "Приложение пупсБанка",
                "В среду вместо ужина"
        );
        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting1);
        String query = "Накатить по второй";

        Task[] expected = {meeting1};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void QueryNothingMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        String query = "После дождичка в четверг";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    //***************************

    @Test
    public void QueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        String query = "мясо";
        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void QueryTwoEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks1 = {"Рубашка", "Трусы", "Штаны"};

        Epic epic = new Epic(55, subtasks);
        Epic epic1 = new Epic(11, subtasks1);

        Todos todos = new Todos();
        todos.add(epic);
        todos.add(epic1);

        String query = "Штаны";

        Task[] expected = {epic1};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void QueryNothingEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        String query = "Чай";
        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

}
