package StructuralDesignPattern.bridge.pattern.abstraction;

import StructuralDesignPattern.bridge.pattern.implementor.MessageSender;

public class UrgentNotification extends Notification{

    public UrgentNotification(MessageSender messageSender) {
        super(messageSender);
    }
    @Override
    public void send(String message) {
        messageSender.sendMessage("[URGENT] " + message);
    }
}
