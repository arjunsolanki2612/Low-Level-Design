package CreationalDesignPattern.abstractFactory.pattern.client;

import CreationalDesignPattern.abstractFactory.pattern.factory.PaymentFactory;
import CreationalDesignPattern.abstractFactory.pattern.product.invoice.Invoice;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.PaymentProcessor;

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
