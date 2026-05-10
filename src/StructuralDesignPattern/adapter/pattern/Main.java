package StructuralDesignPattern.adapter.pattern;

import StructuralDesignPattern.adapter.pattern.adaptee.RazorpayAPI;
import StructuralDesignPattern.adapter.pattern.adapter.RazorPayAdaptor;
import StructuralDesignPattern.adapter.pattern.client.CheckoutService;
import StructuralDesignPattern.adapter.pattern.concrete.PayUGateway;
import StructuralDesignPattern.adapter.pattern.target.PaymentGateway;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Razorpay Payment ===");
        // Create adaptee
        RazorpayAPI razorpayAPI = new RazorpayAPI();

        // Inject adaptee into adapter
        PaymentGateway razorpayAdapter = new RazorPayAdaptor(razorpayAPI);

        // Inject adapter into service
        CheckoutService razorpayCheckout = new CheckoutService(razorpayAdapter);

        razorpayCheckout.checkout("ORD101", 2500);

        System.out.println();

        System.out.println("=== PayU Payment ===");

        // Direct implementation (no adapter needed)
        PaymentGateway payUGateway = new PayUGateway();

        CheckoutService payUCheckout = new CheckoutService(payUGateway);

        payUCheckout.checkout("ORD102", 4500);
    }
}
