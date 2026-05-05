package CreationalDesignPattern.factory.pattern.factory;

import CreationalDesignPattern.factory.pattern.product.EmailNotification;
import CreationalDesignPattern.factory.pattern.product.Notification;

public class EmailFactory implements NotifcationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
