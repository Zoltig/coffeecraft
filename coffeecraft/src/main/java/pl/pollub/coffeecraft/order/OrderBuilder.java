package pl.pollub.coffeecraft.order;

import pl.pollub.coffeecraft.bundle.Component;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private final List<Component> items = new ArrayList<>();
    private String note = "";

    public OrderBuilder withItem(Component c) { items.add(c); return this; }
    public OrderBuilder withNote(String n) { note = n; return this; }
    public Order build() { return new Order(List.copyOf(items), note); }
}
