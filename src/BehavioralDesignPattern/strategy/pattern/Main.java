package BehavioralDesignPattern.strategy.pattern;

import BehavioralDesignPattern.strategy.pattern.context.ShoppingCart;
import BehavioralDesignPattern.strategy.pattern.strategy.CardPayment;
import BehavioralDesignPattern.strategy.pattern.strategy.UpiPayment;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new UpiPayment());
        cart.checkout(1000);

        cart.setPaymentStrategy(new CardPayment());
        cart.checkout(8555);
    }
}
