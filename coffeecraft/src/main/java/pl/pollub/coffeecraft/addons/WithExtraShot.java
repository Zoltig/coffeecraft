package pl.pollub.coffeecraft.addons;

import pl.pollub.coffeecraft.drink.Drink;

public class WithExtraShot extends DrinkDecorator {
    public WithExtraShot(Drink d) { super(d); }
    @Override public String name() { return delegate.name() + " + extra shot"; }
    @Override public double cost() { return delegate.cost() + 3.0; } // placeholder
}
