package CreationalDesignPattern.factory.pattern.product;

public class PushNotification implements Notification{
    @Override
    public void send() {
        System.out.println("Push Notification Sent 🚀");
    }
}
