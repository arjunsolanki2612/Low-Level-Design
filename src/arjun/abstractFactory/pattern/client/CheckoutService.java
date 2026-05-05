package arjun.abstractFactory.pattern.client;

import arjun.abstractFactory.pattern.factory.PaymentFactory;
import arjun.abstractFactory.pattern.product.invoice.Invoice;
import arjun.abstractFactory.pattern.product.payment.PaymentProcessor;

public class CheckoutService {
    PaymentFactory paymentFactory;

    public CheckoutService(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    public void checkout(double amount, String type){
        PaymentProcessor paymentProcessor = paymentFactory.createPaymentProcessor(type);
        paymentProcessor.pay(amount);
        Invoice invoice = paymentFactory.createInvoice();
        invoice.generate(amount);
    }
}
