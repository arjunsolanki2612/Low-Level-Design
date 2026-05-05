package arjun.abstractFactory.pattern;

import arjun.abstractFactory.pattern.client.CheckoutService;
import arjun.abstractFactory.pattern.factory.IndiaPaymentFactory;
import arjun.abstractFactory.pattern.factory.PaymentFactory;
import arjun.abstractFactory.pattern.factory.USAPaymentFactory;

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
