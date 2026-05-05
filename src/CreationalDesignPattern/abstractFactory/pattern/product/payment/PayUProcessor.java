package CreationalDesignPattern.abstractFactory.pattern.product.payment;

public class PayUProcessor implements PaymentProcessor{
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment via PayU: ₹" + amount);
    }
}
