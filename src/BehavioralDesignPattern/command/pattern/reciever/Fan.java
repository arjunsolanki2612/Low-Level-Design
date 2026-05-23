package BehavioralDesignPattern.command.pattern.reciever;

public class Fan {
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
        System.out.println("Fan On");
    }
    public void turnOff(){
        isOn = false;
        System.out.println("Fan Off");
    }
}
