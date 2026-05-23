package BehavioralDesignPattern.strategy.pattern.strategy;

public class PaypalPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println(
                "Paid ₹" + amount + " using Paypal"
        );
    }
}
