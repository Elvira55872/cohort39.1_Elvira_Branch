package example03;

import java.rmi.NoSuchObjectException;

public class Main {
    /*
    Разработать систему для рассылки уведомлений по электронной почте, СМС и другим способам связи
     */

    public static void main(String[] args) {
        Notifier telegramNotifier = new Notifier() {
            @Override
            public void sendMessage(String text) {
                // какой-то код с подключением к TelegramAPI и отсылание сообщения

                System.out.println("Sending message via Telegram: " + text);
            }
        };

        NotificactionManager.broadcastMessage(telegramNotifier, "Hello, this is automated text.......");

        NotificactionManager.broadcastMessage(new SmsNotifier(), "Hello! Are you interested in our......");
        NotificactionManager.broadcastMessage(new EmailNotifier(), "Hello! You received this letter because you agreed to......");

    }
}
