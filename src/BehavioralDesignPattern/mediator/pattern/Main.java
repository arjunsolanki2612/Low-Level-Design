package BehavioralDesignPattern.mediator.pattern;

import BehavioralDesignPattern.mediator.pattern.colleague.ChatUser;
import BehavioralDesignPattern.mediator.pattern.colleague.User;
import BehavioralDesignPattern.mediator.pattern.mediator.ChatRoomMediator;

public class Main {

    public static void main(String[] args) {

        ChatRoomMediator mediator = new ChatRoomMediator();

        User arjun = new ChatUser(mediator, "Arjun");

        User rohit = new ChatUser(mediator, "Rohit");

        User aman = new ChatUser(mediator, "Aman");

        mediator.addUser(arjun);
        mediator.addUser(rohit);
        mediator.addUser(aman);

        System.out.println("\n=== Private Message ===");

        arjun.sendTo("Rohit", "Hello Rohit");


        System.out.println("\n=== Mute Arjun ===");

        mediator.muteUser("Rohit", "Arjun");


        System.out.println("\n=== Private Message After Mute ===");

        arjun.sendTo("Rohit", "Can you hear me?");


        System.out.println("\n=== Broadcast ===");

        arjun.broadcast("Hello Everyone");


        System.out.println("\n=== Unmute ===");

        mediator.unMuteUser("Rohit", "Arjun");


        System.out.println("\n=== Private Message Again ===");

        arjun.sendTo("Rohit", "Now?");
    }
}