package BehavioralDesignPattern.template.pattern;

public abstract class Beverage {
    // TEMPLATE METHOD
    // final prevents subclasses from changing flow
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // Common step
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // Common step
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Variable step
    protected abstract void brew();

    // Variable step
    protected abstract void addCondiments();

    // Hook method
    protected boolean customerWantsCondiments() {
        return true;
    }
}
