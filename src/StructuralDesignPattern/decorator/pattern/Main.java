package StructuralDesignPattern.decorator.pattern;

import StructuralDesignPattern.decorator.pattern.component.Coffee;
import StructuralDesignPattern.decorator.pattern.concrete.Espresso;
import StructuralDesignPattern.decorator.pattern.decorator.MilkDecorator;
import StructuralDesignPattern.decorator.pattern.decorator.SugarDecorator;

public class Main {
    public static void main(String[] args) {

        /*
            STEP 1:
            Create original base object
        */

        Coffee espresso = new Espresso();

        /*
            Current Structure:

                Espresso
        */


        /*
            STEP 2:
            Wrap Espresso with SugarDecorator
        */

        Coffee sugarCoffee =
                new SugarDecorator(espresso);

        /*
            Current Structure:

                SugarDecorator
                    ↓
                 Espresso
        */


        /*
            STEP 3:
            Wrap SugarDecorator with MilkDecorator
        */

        Coffee finalCoffee =
                new MilkDecorator(sugarCoffee);

        /*
            Final Runtime Structure:

                MilkDecorator
                    ↓
                SugarDecorator
                    ↓
                  Espresso

            VERY IMPORTANT:

            finalCoffee variable points to OUTERMOST wrapper.
        */


        /*
            EXECUTION FLOW:

            finalCoffee.getCost()

            -> MilkDecorator.getCost()
                -> SugarDecorator.getCost()
                    -> Espresso.getCost()

            RETURN FLOW:

            Espresso returns 100
            Sugar adds 20 = 120
            Milk adds 40 = 160
        */

        System.out.println("Description: "
                + finalCoffee.getDescription());

        System.out.println("Total Cost: "
                + finalCoffee.getCost());
    }
}
