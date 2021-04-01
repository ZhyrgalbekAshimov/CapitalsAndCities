import Impl.TestingImpl;

public class Main {

    public static void main(String[] args) {

        TestingImpl testing = new TestingImpl();

        testing.addRecordsToDatabase("Kyrgyzstan", "Bishkek");  // Пример. Можно добавить свои данные в базу данных
        testing.addRecordsToDatabase();                                         // Добавление записей в базу данных вопросов

        testing.test();
    }
}
