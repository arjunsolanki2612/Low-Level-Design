package CreationalDesignPattern.factory.pattern.factory;

import CreationalDesignPattern.factory.pattern.product.Notification;
import CreationalDesignPattern.factory.pattern.product.PushNotification;

public class PushFactory implements NotifcationFactory{
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
