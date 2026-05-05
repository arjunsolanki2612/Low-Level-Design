package CreationalDesignPattern.abstractFactory.pattern.factory;

import CreationalDesignPattern.abstractFactory.pattern.product.invoice.Invoice;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.PaymentProcessor;

public interface PaymentFactory {
    PaymentProcessor createPaymentProcessor(String type);
    Invoice createInvoice();
}
