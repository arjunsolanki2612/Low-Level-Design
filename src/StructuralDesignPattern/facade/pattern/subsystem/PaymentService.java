package StructuralDesignPattern.facade.pattern.subsystem;

public class PaymentService {
    public void makePayment(int amount) {
        System.out.println("Payment of Rs." + amount + " successful");
    }
}
