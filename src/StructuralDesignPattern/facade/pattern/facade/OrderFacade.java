package StructuralDesignPattern.facade.pattern.facade;

import StructuralDesignPattern.facade.pattern.subsystem.InventoryService;
import StructuralDesignPattern.facade.pattern.subsystem.InvoiceService;
import StructuralDesignPattern.facade.pattern.subsystem.NotificationService;
import StructuralDesignPattern.facade.pattern.subsystem.PaymentService;

public class OrderFacade {
    private PaymentService paymentService;
    private InventoryService inventoryService;
    private InvoiceService invoiceService;
    private NotificationService notificationService;

    public OrderFacade(){
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.invoiceService = new InvoiceService();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(String product,int amount){
        System.out.println("\nPlacing Order...\n");

        paymentService.makePayment(amount);
        inventoryService.reserveProduct(product);
        invoiceService.generateInvoice(product);
        notificationService.sendNotification();

        System.out.println("\nOrder Placed Successfully");
    }
}
