package BehavioralDesignPattern.state.pattern;

import BehavioralDesignPattern.state.pattern.context.MediaPlayer;
import BehavioralDesignPattern.state.pattern.state.ReadyState;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
        ReadyState readyState = new ReadyState(player);
        player.setState(readyState);
        player.showCurrentState();;
        player.pressPlay();
        player.showCurrentState();
        player.pressPlay();
        player.pressNext();
        player.pressPlay();
        player.showCurrentState();
        player.pressPlay();
        player.showCurrentState();
    }
}
