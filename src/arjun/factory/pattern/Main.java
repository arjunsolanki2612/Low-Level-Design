package arjun.factory.pattern;

import arjun.factory.pattern.factory.EmailFactory;
import arjun.factory.pattern.factory.PushFactory;
import arjun.factory.pattern.factory.SMSFactory;
import arjun.factory.pattern.service.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new EmailFactory());
        notificationService.sendNotification();

        NotificationService notificationService1 = new NotificationService(new SMSFactory());
        notificationService1.sendNotification();

        NotificationService notificationService2 = new NotificationService(new PushFactory());
        notificationService2.sendNotification();;
    }
}
