package CreationalDesignPattern.factory.pattern.service;

import CreationalDesignPattern.factory.pattern.factory.NotifcationFactory;
import CreationalDesignPattern.factory.pattern.product.Notification;

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
