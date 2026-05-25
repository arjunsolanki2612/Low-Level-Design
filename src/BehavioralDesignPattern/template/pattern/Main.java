package BehavioralDesignPattern.template.pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Coffee---");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println();

        System.out.println("---Tea---");
        Beverage tea =  new Tea();
        tea.prepareRecipe();
    }
}
