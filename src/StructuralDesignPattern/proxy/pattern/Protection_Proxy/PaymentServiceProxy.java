package StructuralDesignPattern.proxy.pattern.Protection_Proxy;

public class PaymentServiceProxy implements PaymentService {

    private RealPaymentService realPaymentService;

    public PaymentServiceProxy() {
        this.realPaymentService = new RealPaymentService();
    }

    @Override
    public void pay(String userRole, double amount) {

        System.out.println("Payment request received.");
        System.out.println("Checking access for role: " + userRole);

        if (!userRole.equalsIgnoreCase("ADMIN")) {
            System.out.println("Access denied. Only ADMIN can perform payment.");
            return;
        }

        System.out.println("Access granted.");
        System.out.println("Logging payment request for amount: " + amount);

        realPaymentService.pay(userRole, amount);

        System.out.println("Payment request completed.");
    }
}