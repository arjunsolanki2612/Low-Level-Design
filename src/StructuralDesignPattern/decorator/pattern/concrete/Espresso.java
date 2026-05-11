package StructuralDesignPattern.decorator.pattern.concrete;

import StructuralDesignPattern.decorator.pattern.component.Coffee;

// The Base Concrete class
public class Espresso implements Coffee {

    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Espresso ";
    }
}
