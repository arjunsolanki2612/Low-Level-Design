package arjun.factory.pattern.factory;

import arjun.factory.pattern.product.EmailNotification;
import arjun.factory.pattern.product.Notification;

public class EmailFactory implements NotifcationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
