package CreationalDesignPattern.abstractFactory.pattern.factory;

import CreationalDesignPattern.abstractFactory.pattern.product.invoice.IndiaInvoice;
import CreationalDesignPattern.abstractFactory.pattern.product.invoice.Invoice;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.PayUProcessor;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.PaymentProcessor;
import CreationalDesignPattern.abstractFactory.pattern.product.payment.RazorPayProcessor;

public class IndiaPaymentFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createPaymentProcessor(String type) {

        if (type.equalsIgnoreCase("RAZORPAY")) {
            return new RazorPayProcessor();
        }
        else if (type.equalsIgnoreCase("PAYU")) {
            return new PayUProcessor();
        }

        throw new IllegalArgumentException("Invalid payment type for INDIA");
    }

    @Override
    public Invoice createInvoice() {
        return new IndiaInvoice();
    }
}
