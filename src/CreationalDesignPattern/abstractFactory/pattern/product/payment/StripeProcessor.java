package CreationalDesignPattern.abstractFactory.pattern.product.payment;

public class StripeProcessor implements  PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment via Stripe: ₹" + amount);
    }
}
