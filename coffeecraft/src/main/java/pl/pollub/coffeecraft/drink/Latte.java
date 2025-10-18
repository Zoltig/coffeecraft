package pl.pollub.coffeecraft.drink;

public class Latte implements Drink {
    @Override public String name() { return "Latte"; }
    @Override public double cost() { return 12.0; }
}
