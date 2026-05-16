package StructuralDesignPattern.proxy.pattern.Protection_Proxy;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentServiceProxy();

        System.out.println("User trying payment:");
        paymentService.pay("USER", 5000);

        System.out.println();

        System.out.println("Admin trying payment:");
        paymentService.pay("ADMIN", 5000);
    }
}
