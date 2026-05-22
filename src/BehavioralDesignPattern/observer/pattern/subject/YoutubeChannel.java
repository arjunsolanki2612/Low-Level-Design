package BehavioralDesignPattern.observer.pattern.subject;

import BehavioralDesignPattern.observer.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{

    private List<Observer> observerList;
    private String videoTitle;

    public YoutubeChannel() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        System.out.println("Subscriber added: "+observer);
        observerList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        System.out.println("Subscriber Removed: "+observer);
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: observerList){
            observer.update(videoTitle);
        }
    }

    public void uploadVideo(String videoTitle){
        System.out.println("\nNew Video Uploaded: " + videoTitle);

        this.videoTitle = videoTitle;

        notifyObserver();
    }
}
