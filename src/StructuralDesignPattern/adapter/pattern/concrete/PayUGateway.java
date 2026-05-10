package StructuralDesignPattern.adapter.pattern.concrete;

import StructuralDesignPattern.adapter.pattern.target.PaymentGateway;

public class PayUGateway implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {

        System.out.println(
                "Paid Rs." + amount +
                        " using PayU for order: " + orderId
        );
    }
}
