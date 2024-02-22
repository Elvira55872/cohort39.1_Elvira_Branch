package example03;

public class EmailNotifier implements Notifier {
    @Override
    public void sendMessage(String text) {
        // какой-то реальный код с подключением и отсыланием письма...

        System.out.println("Sending message via Email: " + text);
    }
}
