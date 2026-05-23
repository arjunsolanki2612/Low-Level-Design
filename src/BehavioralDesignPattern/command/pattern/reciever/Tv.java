package BehavioralDesignPattern.command.pattern.reciever;

public class Tv {
    public boolean isOn=false;

    public void toggle(){
        if(isOn){
            turnOff();
        }else{
            turnOn();
        }
    }

    public void turnOn(){
        isOn = true;
        System.out.println("TV On");
    }
    public void turnOff(){
        isOn = false;
        System.out.println("TV Off");
    }
}
