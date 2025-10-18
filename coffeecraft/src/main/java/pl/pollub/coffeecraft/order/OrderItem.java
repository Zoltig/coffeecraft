package pl.pollub.coffeecraft.order;

import pl.pollub.coffeecraft.bundle.Component;

public record OrderItem(Component component, int quantity) {
    public double price() { return component.price() * quantity; }
}
