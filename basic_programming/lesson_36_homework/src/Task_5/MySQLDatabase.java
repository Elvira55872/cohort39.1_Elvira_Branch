package Task_5;

public class MySQLDatabase implements Database{
    @Override
    public void read() {
        // какая то логика чтения
    }

    @Override
    public String write() {
        return "MySQLDatabase";
    }
}
