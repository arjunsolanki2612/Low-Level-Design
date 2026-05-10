package StructuralDesignPattern.adapter.pattern.adapter;

import StructuralDesignPattern.adapter.pattern.adaptee.RazorpayAPI;
import StructuralDesignPattern.adapter.pattern.target.PaymentGateway;

public class RazorPayAdaptor implements PaymentGateway {
    private RazorpayAPI razorpayAPI;

    public RazorPayAdaptor(RazorpayAPI razorpayAPI) {
        this.razorpayAPI = razorpayAPI;
    }

    public void pay(String orderId, double amount) {

        System.out.println(
                "Adapter translating pay() to makePayment()"
        );

        razorpayAPI.makePayment(orderId, amount);
    }
}
