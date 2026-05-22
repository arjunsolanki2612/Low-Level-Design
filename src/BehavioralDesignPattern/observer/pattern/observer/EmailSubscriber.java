package BehavioralDesignPattern.observer.pattern.observer;

public class EmailSubscriber implements Observer{
    private String email;
    public EmailSubscriber(String email){
        this.email = email;
    }

    @Override
    public void update(String videoTitle){
        System.out.println(
                "Mobile Notification to " + email +
                        ": New video uploaded -> " + videoTitle
        );
    }

    @Override
    public String toString() {
        return "EmailSubscriber{email='" + email + "'}";
    }
}
