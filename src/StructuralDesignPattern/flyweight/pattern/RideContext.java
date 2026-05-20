package StructuralDesignPattern.flyweight.pattern;

public class RideContext {

    private String pickUp;
    private String drop;
    private DriverProfile driverProfile;

    public RideContext(String pickUp, String drop, DriverProfile driverProfile) {
        this.pickUp = pickUp;
        this.drop = drop;
        this.driverProfile = driverProfile;
    }

    public void showRide() {

        System.out.println(
                "Pickup: " + pickUp +
                        ", Drop: " + drop
        );

        driverProfile.showDriverDetails();

        System.out.println();
    }
}
