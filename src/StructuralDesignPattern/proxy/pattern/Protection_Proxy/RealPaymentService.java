package StructuralDesignPattern.proxy.pattern.Protection_Proxy;

public class RealPaymentService implements PaymentService {

    @Override
    public void pay(String userRole, double amount) {
        System.out.println("Processing payment of amount: " + amount);
        System.out.println("Payment successful.");
    }
}
