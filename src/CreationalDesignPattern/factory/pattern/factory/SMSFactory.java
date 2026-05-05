package CreationalDesignPattern.factory.pattern.factory;

import CreationalDesignPattern.factory.pattern.product.Notification;
import CreationalDesignPattern.factory.pattern.product.SMSNotification;

public class SMSFactory implements NotifcationFactory{
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
