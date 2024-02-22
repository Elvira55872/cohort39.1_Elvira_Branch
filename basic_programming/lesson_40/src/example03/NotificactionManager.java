package example03;

public class NotificactionManager {
    public static void broadcastMessage(Notifier notifier, String message) {
        // какой-то реально нужный код здесь...

        notifier.sendMessage(message);
    }
}
