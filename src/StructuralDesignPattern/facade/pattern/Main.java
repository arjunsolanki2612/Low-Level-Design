package StructuralDesignPattern.facade.pattern;

import StructuralDesignPattern.facade.pattern.facade.OrderFacade;

public class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("IPhone 17", 150000);
    }
}
