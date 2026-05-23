package BehavioralDesignPattern.command.pattern.command;

import BehavioralDesignPattern.command.pattern.reciever.Fan;

public class ToggleFanCommand implements Command{
    private Fan fan;

    public ToggleFanCommand(Fan fan){
        this.fan = fan;
    }

    public void execute(){
        fan.toggle();
    }
}
