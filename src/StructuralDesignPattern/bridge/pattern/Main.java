package StructuralDesignPattern.bridge.pattern;

import StructuralDesignPattern.bridge.pattern.abstraction.Notification;
import StructuralDesignPattern.bridge.pattern.abstraction.PromotionalNotification;
import StructuralDesignPattern.bridge.pattern.abstraction.SimpleNotification;
import StructuralDesignPattern.bridge.pattern.implementor.EmailSender;
import StructuralDesignPattern.bridge.pattern.implementor.WhatsAppSender;

public class Main {
    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        Notification notification = new SimpleNotification(emailSender);
        notification.send("Hello, this is a simple notification");

        WhatsAppSender whatsAppSender = new WhatsAppSender();
        Notification whatsappNotification = new PromotionalNotification(whatsAppSender);
        whatsappNotification.send("Hello, this is a Promotional notification");
    }
}
