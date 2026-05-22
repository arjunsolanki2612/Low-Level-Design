package BehavioralDesignPattern.observer.pattern.subject;

import BehavioralDesignPattern.observer.pattern.observer.Observer;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObserver();
}
