package StructuralDesignPattern.bridge.pattern.implementor;

public class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " +message);
    }

}
