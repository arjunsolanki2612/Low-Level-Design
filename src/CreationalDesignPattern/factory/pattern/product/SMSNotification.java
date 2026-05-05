package CreationalDesignPattern.factory.pattern.product;

public class SMSNotification implements Notification{
    @Override
    public void send() {
        System.out.println("SMS Sent 🚀");
    }
}
