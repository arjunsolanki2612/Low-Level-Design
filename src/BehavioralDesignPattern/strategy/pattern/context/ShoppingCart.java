package BehavioralDesignPattern.strategy.pattern.context;

import BehavioralDesignPattern.strategy.pattern.strategy.PaymentStrategy;

public class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }

}
