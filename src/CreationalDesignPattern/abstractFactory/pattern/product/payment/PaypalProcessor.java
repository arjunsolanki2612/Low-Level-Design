package CreationalDesignPattern.abstractFactory.pattern.product.payment;

public class PaypalProcessor implements PaymentProcessor{
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment via Paypal: ₹" + amount);
    }
}
