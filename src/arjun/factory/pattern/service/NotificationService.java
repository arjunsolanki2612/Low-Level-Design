package arjun.factory.pattern.service;

import arjun.factory.pattern.factory.NotifcationFactory;
import arjun.factory.pattern.product.Notification;

public class NotificationService {
    private NotifcationFactory factory;
    public NotificationService(NotifcationFactory factory) {
        this.factory = factory;
    }

    public void sendNotification(){
        Notification notification = factory.createNotification();
        notification.send();
    }
}
