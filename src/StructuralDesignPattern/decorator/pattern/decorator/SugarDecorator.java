package StructuralDesignPattern.decorator.pattern.decorator;

import StructuralDesignPattern.decorator.pattern.component.Coffee;

public class SugarDecorator extends CoffeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 20.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "Sugar ";
    }
}
