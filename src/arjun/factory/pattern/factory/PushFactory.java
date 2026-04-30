package arjun.factory.pattern.factory;

import arjun.factory.pattern.product.Notification;
import arjun.factory.pattern.product.PushNotification;

public class PushFactory implements NotifcationFactory{
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
