package BehavioralDesignPattern.command.pattern;

import BehavioralDesignPattern.command.pattern.command.Command;
import BehavioralDesignPattern.command.pattern.command.ToggleAcCommand;
import BehavioralDesignPattern.command.pattern.command.ToggleFanCommand;
import BehavioralDesignPattern.command.pattern.command.ToggleTvCommand;
import BehavioralDesignPattern.command.pattern.invoker.RemoteControl;
import BehavioralDesignPattern.command.pattern.reciever.AC;
import BehavioralDesignPattern.command.pattern.reciever.Fan;
import BehavioralDesignPattern.command.pattern.reciever.Tv;

public class Main {
    public static void main(String[] args) {

    // Receivers
    Tv tv = new Tv();
    Fan fan = new Fan();
    AC ac = new AC();

    // Commands
    Command tvCommand = new ToggleTvCommand(tv);
    Command fanCommand = new ToggleFanCommand(fan);
    Command acCommand = new ToggleAcCommand(ac);

    // Invoker
    RemoteControl remote = new RemoteControl(3);

    // Assign buttons
        remote.setCommand(0, tvCommand);
        remote.setCommand(1, fanCommand);
        remote.setCommand(2, acCommand);

    // TV Toggle
        remote.pressButton(0);
        remote.pressButton(0);

        System.out.println();

    // Fan Toggle
        remote.pressButton(1);
        remote.pressButton(1);

        System.out.println();

    // AC Toggle
        remote.pressButton(2);
        remote.pressButton(2);
    }
}

