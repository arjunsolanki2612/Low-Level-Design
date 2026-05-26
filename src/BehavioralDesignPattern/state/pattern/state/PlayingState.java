package BehavioralDesignPattern.state.pattern.state;

import BehavioralDesignPattern.state.pattern.context.MediaPlayer;

public class PlayingState implements State {
    private MediaPlayer player;

    public PlayingState(MediaPlayer player) {
        this.player = player;
    }

    @Override
    public void pressPlay() {
        System.out.println("Pausing music");
        player.setState(new PausedState(player));
    }

    @Override
    public void pressNext() {
        System.out.println("Playing next song");
    }
}
