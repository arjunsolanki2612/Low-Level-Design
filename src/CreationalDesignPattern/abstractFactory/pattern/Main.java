package CreationalDesignPattern.abstractFactory.pattern;

import CreationalDesignPattern.abstractFactory.pattern.client.CheckoutService;
import CreationalDesignPattern.abstractFactory.pattern.factory.IndiaPaymentFactory;
import CreationalDesignPattern.abstractFactory.pattern.factory.PaymentFactory;
import CreationalDesignPattern.abstractFactory.pattern.factory.USAPaymentFactory;

public class Main {
    public static void main(String[] args) {
        String region = "INDIA";     // INDIA / USA
        String paymentType = "PAYU"; // RAZORPAY / PAYU / STRIPE / PAYPAL

        PaymentFactory factory;

        if (region.equalsIgnoreCase("INDIA")) {
            factory = new IndiaPaymentFactory();
        } else {
            factory = new USAPaymentFactory();
        }

        CheckoutService checkout = new CheckoutService(factory);
        checkout.checkout(2000, paymentType);
    }
}
