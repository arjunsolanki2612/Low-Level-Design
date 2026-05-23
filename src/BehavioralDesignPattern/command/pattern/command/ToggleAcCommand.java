package BehavioralDesignPattern.command.pattern.command;

import BehavioralDesignPattern.command.pattern.reciever.AC;

public class ToggleAcCommand implements Command{
    private AC ac;
    public ToggleAcCommand(AC ac){
        this.ac = ac;
    }

    public void execute(){
        ac.toggle();
    }
}
