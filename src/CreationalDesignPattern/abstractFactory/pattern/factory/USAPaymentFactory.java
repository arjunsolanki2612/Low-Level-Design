package CreationalDesignPattern.abstractFactory.pattern.factory;

import CreationalDesignPattern.abstractFactory.pattern.product.invoice.Invoice;
import CreationalDesignPattern.abstractFactory.pattern.product.invoice.USAInvoice;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.PaymentProcessor;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.PaypalProcessor;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.StripeProcessor;

public class USAPaymentFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createPaymentProcessor(String type) {

        if (type.equalsIgnoreCase("STRIPE")) {
            return new StripeProcessor();
        }
        else if (type.equalsIgnoreCase("PAYPAL")) {
            return new PaypalProcessor();
        }

        throw new IllegalArgumentException("Invalid payment type for USA");
    }

    @Override
    public Invoice createInvoice() {
        return new USAInvoice();
    }
}
