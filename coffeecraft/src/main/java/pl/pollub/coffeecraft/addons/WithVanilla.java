package pl.pollub.coffeecraft.addons;

import pl.pollub.coffeecraft.drink.Drink;

public class WithVanilla extends DrinkDecorator {
    public WithVanilla(Drink d) { super(d); }
    @Override public String name() { return delegate.name() + " + vanilla"; }
    @Override public double cost() { return delegate.cost() + 2.0; }
}
