package BehavioralDesignPattern.command.pattern.invoker;

import BehavioralDesignPattern.command.pattern.command.Command;

public class RemoteControl {
    private Command[] buttons;

    public RemoteControl(int numberOfButtons){
        buttons = new Command[numberOfButtons];
    }

    public void setCommand(int buttonNumber, Command command){
        buttons[buttonNumber] = command;
    }

    public void pressButton(int buttonNumber){
        buttons[buttonNumber].execute();
    }



}
