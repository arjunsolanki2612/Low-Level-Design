package StructuralDesignPattern.flyweight.pattern;

public class Main {
    public static void main(String[] args) {

    DriverProfile profile1 = DriverProfileFactory.getProfile("Arjun","mercedes","white","sedan");
    RideContext rideContext = new RideContext("Wazidpur","TCS Noida 2",profile1);



    DriverProfile profile2 = DriverProfileFactory.getProfile("Arjun","mercedes","white","sedan");
    RideContext rideContext2 = new RideContext("Wazidpur","TCS Noida 2",profile2);

    rideContext.showRide();
    rideContext2.showRide();
    }


}
