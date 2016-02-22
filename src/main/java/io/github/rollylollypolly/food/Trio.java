package io.github.rollylollypolly.food;

/**
 * Created by rolypoly on 2/19/16.
 */
public class Trio implements MenuItem {
    private final Sandwich sandwich;
    private final Salad salad;
    private final Drink drink;
    Trio(Sandwich sandwich, Salad salad, Drink drink) {
        this.sandwich = sandwich;
        this.salad = salad;
        this.drink = drink;
    }
    @Override
    public String name() {
        return sandwich.name() + "/" + salad.name() + "/" + drink.name();
    }

    @Override
    public double price() {
        double low;
        if (sandwich.price() < salad.price()) if (salad.price() < drink.price()) low = drink.price();
        double lower;
        double lowest;
        return 0;
    }
}
