package BehavioralDesignPattern.mediator.pattern.mediator;

import BehavioralDesignPattern.mediator.pattern.colleague.User;

public interface ChatMediator {

    void addUser(User user);

    void sendTo(String message, User sender, String receiverName);

    void broadcast(String message, User sender);

    void muteUser(String userName, String mutedUserName);

    void unMuteUser(String userName, String mutedUserName);
}
