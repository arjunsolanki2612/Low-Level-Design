package StructuralDesignPattern.decorator.pattern.decorator;

import StructuralDesignPattern.decorator.pattern.component.Coffee;

public class MilkDecorator extends CoffeDecorator{

    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 40.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "Milk ";
    }
}
