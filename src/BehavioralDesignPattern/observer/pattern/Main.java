package BehavioralDesignPattern.observer.pattern;

import BehavioralDesignPattern.observer.pattern.observer.EmailSubscriber;
import BehavioralDesignPattern.observer.pattern.observer.MobileSubscriber;
import BehavioralDesignPattern.observer.pattern.observer.Observer;
import BehavioralDesignPattern.observer.pattern.subject.YoutubeChannel;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();

        Observer user1 = new MobileSubscriber("Arjun");
        Observer user2 = new EmailSubscriber("Ajay@gmail.com");

        youtubeChannel.subscribe(user1);
        youtubeChannel.subscribe(user2);

        youtubeChannel.uploadVideo("Java Design Patterns");

        youtubeChannel.unsubscribe(user1);
        youtubeChannel.uploadVideo("Java Multithreading Tutorial");
    }
}
