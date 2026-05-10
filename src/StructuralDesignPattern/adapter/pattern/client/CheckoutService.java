package StructuralDesignPattern.adapter.pattern.client;

import StructuralDesignPattern.adapter.pattern.target.PaymentGateway;

public class CheckoutService {
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway  = paymentGateway;
    }

    public void checkout(String orderId, double amount) {

        System.out.println(
                "Checkout started for order: " + orderId
        );

        paymentGateway.pay(orderId, amount);
        System.out.println("Checkout completed");
    }
}
