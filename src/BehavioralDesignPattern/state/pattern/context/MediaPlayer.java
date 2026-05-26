package BehavioralDesignPattern.state.pattern.context;

import BehavioralDesignPattern.state.pattern.state.State;

public class MediaPlayer {
    private State currentState;

    public void setState(State state) {
        this.currentState = state;

        System.out.println("State changed to: " + state.getClass().getSimpleName());
    }

    public void pressPlay(){
        currentState.pressPlay();
    }

    public void pressNext(){
        currentState.pressNext();
    }

    public void showCurrentState(){
        System.out.println("Current State: " + currentState.getClass().getSimpleName());
    }
}
