package BehavioralDesignPattern.command.pattern.reciever;

public class AC {
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
        System.out.println("AC On");
    }
    public void turnOff(){
        isOn = false;
        System.out.println("AC Off");
    }
}
