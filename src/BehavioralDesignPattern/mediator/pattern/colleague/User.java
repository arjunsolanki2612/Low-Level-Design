package BehavioralDesignPattern.mediator.pattern.colleague;

import BehavioralDesignPattern.mediator.pattern.mediator.ChatMediator;
import BehavioralDesignPattern.mediator.pattern.mediator.ChatRoomMediator;

public abstract class User {

    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void sendTo(
            String receiverName,
            String message);

    public abstract void broadcast(
            String message);

    public abstract void receive(
            String senderName,
            String message);
}
