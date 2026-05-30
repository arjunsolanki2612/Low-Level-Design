package BehavioralDesignPattern.mediator.pattern.mediator;

import BehavioralDesignPattern.mediator.pattern.colleague.ChatUser;
import BehavioralDesignPattern.mediator.pattern.colleague.User;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class ChatRoomMediator implements ChatMediator {

    private Map<String, User> users = new HashMap<>();

    private Map<String, Set<String>> mutedUsers = new HashMap<>();


    @Override
    public void addUser(User user) {

        users.put(user.getName(), user);

        mutedUsers.putIfAbsent(user.getName(), new HashSet<>());
    }

    @Override
    public void sendTo(String message, User sender, String receiverName) {

        User receiver = users.get(receiverName);

        if (receiver == null) {

            System.out.println("User not found: " + receiverName);

            return;
        }

        if (isMuted(receiverName, sender.getName())) {

            System.out.println(receiverName + " has muted " + sender.getName());

            return;
        }

        receiver.receive(sender.getName(), message);
    }

    @Override
    public void broadcast(String message, User sender) {

        for (User user : users.values()) {

            if (user == sender) {
                continue;
            }

            if (isMuted(user.getName(), sender.getName())) {

                continue;
            }

            user.receive(sender.getName(), message);
        }
    }

    @Override
    public void muteUser(String userName, String mutedUserName) {

        mutedUsers.get(userName).add(mutedUserName);
    }

    @Override
    public void unMuteUser(String userName, String mutedUserName) {

        mutedUsers.get(userName).remove(mutedUserName);
    }

    private boolean isMuted(String receiverName, String senderName) {

        return mutedUsers.get(receiverName).contains(senderName);
    }
}