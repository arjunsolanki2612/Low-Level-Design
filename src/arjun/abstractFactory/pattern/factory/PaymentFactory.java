package arjun.abstractFactory.pattern.factory;

import arjun.abstractFactory.pattern.product.invoice.Invoice;
import arjun.abstractFactory.pattern.product.payment.PaymentProcessor;

public interface PaymentFactory {
    PaymentProcessor createPaymentProcessor(String type);
    Invoice createInvoice();
}
