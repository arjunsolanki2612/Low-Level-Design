package arjun.abstractFactory.pattern.product.invoice;

public class USAInvoice implements Invoice {
    @Override
    public void generate(double amount) {
        System.out.println("Generating Tax Invoice for $" + amount);
    }
}
