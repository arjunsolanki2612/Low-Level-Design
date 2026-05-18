package StructuralDesignPattern.bridge.pattern.implementor;

public class WhatsAppSender  implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending WhatsApp message: " + message);
    }

}