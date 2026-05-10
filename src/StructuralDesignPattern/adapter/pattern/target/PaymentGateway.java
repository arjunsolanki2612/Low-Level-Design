package StructuralDesignPattern.adapter.pattern.target;

public interface PaymentGateway {
    void pay(String orderId, double amount);
}
