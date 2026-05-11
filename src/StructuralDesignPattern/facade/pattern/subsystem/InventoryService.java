package StructuralDesignPattern.facade.pattern.subsystem;

public class InventoryService {
    public void reserveProduct(String product) {
        System.out.println(product + " reserved from inventory");
    }
}
