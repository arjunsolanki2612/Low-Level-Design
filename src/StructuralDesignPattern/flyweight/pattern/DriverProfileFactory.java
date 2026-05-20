package StructuralDesignPattern.flyweight.pattern;

import java.util.HashMap;
import java.util.Map;

public class DriverProfileFactory {
    public static Map<String, DriverProfile> driverProfileMap = new HashMap<>();

    public static DriverProfile getProfile(String driverName,
                                           String carModel,
                                           String carColor,
                                           String vehicleType){
        String Key = driverName + "_" + carModel + "_" + carColor + "_" + vehicleType;
        if(!driverProfileMap.containsKey(Key)) {
            System.out.println("Creating new driver profile");
            driverProfileMap.put(Key, new DriverProfile(driverName, carModel, carColor, vehicleType));
        }
        return driverProfileMap.get(Key);
    }
}
