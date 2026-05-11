package StructuralDesignPattern.decorator.pattern.decorator;

import StructuralDesignPattern.decorator.pattern.component.Coffee;

public abstract class CoffeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}
