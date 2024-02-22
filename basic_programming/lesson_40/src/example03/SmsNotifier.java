package example03;

public class SmsNotifier implements Notifier {

    @Override
    public void sendMessage(String text) {
        // какой-то реальный код с подключением и отсыланием сообщения...

        System.out.println("Sending message via SMS: " + text);
    }
}
