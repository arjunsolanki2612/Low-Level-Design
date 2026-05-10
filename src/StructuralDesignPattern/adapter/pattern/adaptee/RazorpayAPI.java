package StructuralDesignPattern.adapter.pattern.adaptee;

public class RazorpayAPI {
    public void makePayment(String invoiceId,
                            double amountInRupees) {

        System.out.println(
                "Paid Rs." + amountInRupees +
                        " using Razorpay for invoice: " + invoiceId
        );
    }
}
