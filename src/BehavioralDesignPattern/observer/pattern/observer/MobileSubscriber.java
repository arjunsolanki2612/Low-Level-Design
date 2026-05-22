package BehavioralDesignPattern.observer.pattern.observer;

public class MobileSubscriber implements Observer{

    private String name;
    public MobileSubscriber(String name){
        this.name = name;
    }

    @Override
    public void update(String videoTitle){
        System.out.println(
                "Mobile Notification to " + name +
                        ": New video uploaded -> " + videoTitle
        );
    }

    @Override
    public String toString() {
        return "MobileSubscriber{name='" + name + "'}";
    }
}
