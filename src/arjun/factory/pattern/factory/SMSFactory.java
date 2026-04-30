package arjun.factory.pattern.factory;

import arjun.factory.pattern.product.Notification;
import arjun.factory.pattern.product.SMSNotification;

public class SMSFactory implements NotifcationFactory{
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
