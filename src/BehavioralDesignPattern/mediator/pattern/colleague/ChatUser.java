package BehavioralDesignPattern.mediator.pattern.colleague;

import BehavioralDesignPattern.mediator.pattern.mediator.ChatMediator;
import BehavioralDesignPattern.mediator.pattern.mediator.ChatRoomMediator;

import java.util.Map;

public class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {

        super(mediator, name);
    }

    @Override
    public void sendTo(String receiverName, String message) {

        System.out.println(name + " sends private message to " + receiverName);

        mediator.sendTo(message, this, receiverName);
    }

    @Override
    public void broadcast(String message) {

        System.out.println(name + " broadcasts: " + message);

        mediator.broadcast(message, this);
    }

    @Override
    public void receive(String senderName, String message) {

        System.out.println(name + " received from " + senderName + " : " + message);
    }
}