package StructuralDesignPattern.bridge.pattern.abstraction;

import StructuralDesignPattern.bridge.pattern.implementor.MessageSender;

public abstract class Notification {

    protected MessageSender messageSender;
    public Notification(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public abstract void send(String message);
}
