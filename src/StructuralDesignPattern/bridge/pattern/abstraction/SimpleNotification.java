package StructuralDesignPattern.bridge.pattern.abstraction;

import StructuralDesignPattern.bridge.pattern.implementor.MessageSender;

public class SimpleNotification extends Notification{
    public SimpleNotification(MessageSender messageSender){
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("Simple: " + message);
    }
}
