package StructuralDesignPattern.flyweight.pattern;

public class DriverProfile {

    private String driverName;
    private String carModel;
    private String carColor;
    private String vehicleType;

    public DriverProfile(String driverName,
                         String carModel,
                         String carColor,
                         String vehicleType) {

        this.driverName = driverName;
        this.carModel = carModel;
        this.carColor = carColor;
        this.vehicleType = vehicleType;
    }

    public void showDriverDetails() {

        System.out.println(
                driverName + " | " +
                        carModel + " | " +
                        carColor + " | " +
                        vehicleType
        );
    }
}