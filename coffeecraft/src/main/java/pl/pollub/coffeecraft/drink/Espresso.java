package pl.pollub.coffeecraft.drink;

public class Espresso implements Drink {
    @Override public String name() { return "Espresso"; }
    @Override public double cost() { return 8.0; }
}
