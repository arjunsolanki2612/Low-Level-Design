package StructuralDesignPattern.facade.pattern.subsystem;

public class InvoiceService {
    public void generateInvoice(String product) {
        System.out.println("Invoice generated for " + product);
    }
}
