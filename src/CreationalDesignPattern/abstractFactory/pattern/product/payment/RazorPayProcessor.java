package CreationalDesignPattern.abstractFactory.pattern.product.payment;

public class RazorPayProcessor implements PaymentProcessor{
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment via RazorPay: ₹" + amount);
    }
}
