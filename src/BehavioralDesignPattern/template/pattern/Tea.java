package BehavioralDesignPattern.template.pattern;

public class Tea extends Beverage{
    @Override
    protected void brew() {
        System.out.println("Steeping Tea Leaves");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
