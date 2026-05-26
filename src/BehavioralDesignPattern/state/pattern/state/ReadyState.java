package BehavioralDesignPattern.state.pattern.state;

import BehavioralDesignPattern.state.pattern.context.MediaPlayer;

public class ReadyState implements State {
    private MediaPlayer player;

    public ReadyState(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void pressPlay() {
        System.out.println("Starting music");
        player.setState(new PlayingState(player));
    }

    @Override
    public void pressNext() {
        System.out.println("No song is currently playing");
    }
}
