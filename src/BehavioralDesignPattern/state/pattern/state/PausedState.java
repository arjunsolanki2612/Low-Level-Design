package BehavioralDesignPattern.state.pattern.state;

import BehavioralDesignPattern.state.pattern.context.MediaPlayer;

public class PausedState implements State {
    private MediaPlayer player;

    public PausedState(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void pressPlay() {
        System.out.println("Resuming music");
        player.setState(new PlayingState(player));
    }

    @Override
    public void pressNext() {
        System.out.println("cannot change song while paused");
    }
}

