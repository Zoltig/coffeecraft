package pl.pollub.coffeecraft.addons;

import pl.pollub.coffeecraft.drink.Drink;

public class WithWhippedCream extends DrinkDecorator {
    public WithWhippedCream(Drink d) { super(d); }
    @Override public String name() { return delegate.name() + " + whipped cream"; }
    @Override public double cost() { return delegate.cost() + 2.5; }
}
