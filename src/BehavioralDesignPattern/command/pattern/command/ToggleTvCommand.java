package BehavioralDesignPattern.command.pattern.command;

import BehavioralDesignPattern.command.pattern.reciever.Tv;

public class ToggleTvCommand implements Command {

    private Tv tv;

    public ToggleTvCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.toggle();
    }
}