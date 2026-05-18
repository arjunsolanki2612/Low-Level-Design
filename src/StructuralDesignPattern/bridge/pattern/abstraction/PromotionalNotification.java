package StructuralDesignPattern.bridge.pattern.abstraction;

import StructuralDesignPattern.bridge.pattern.implementor.MessageSender;

public class PromotionalNotification extends  Notification {

    public PromotionalNotification(MessageSender messageSender){
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("Promotional: " + message);
    }
}
