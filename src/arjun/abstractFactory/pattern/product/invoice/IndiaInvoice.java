package arjun.abstractFactory.pattern.product.invoice;

public class IndiaInvoice implements Invoice {
    @Override
    public void generate(double amount) {
        System.out.println("Generating invoice for India: ₹" + amount);
    }
}
