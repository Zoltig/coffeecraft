package pl.pollub.coffeecraft.addons;

import pl.pollub.coffeecraft.drink.Drink;

public abstract class DrinkDecorator implements Drink {
    protected final Drink delegate;
    protected DrinkDecorator(Drink d) { this.delegate = d; }

    @Override public String name() { return delegate.name(); }
    @Override public double cost() { return delegate.cost(); }
}
