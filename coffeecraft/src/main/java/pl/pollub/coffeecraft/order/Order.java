package pl.pollub.coffeecraft.order;

import pl.pollub.coffeecraft.bundle.Component;

import java.util.List;

public class Order {
    private final List<Component> items;
    private final String note;

    Order(List<Component> items, String note) {
        this.items = items;
        this.note = note;
    }

    public double total() {
        return items.stream().mapToDouble(Component::price).sum();
    }

    public List<Component> items(){ return items; }
    public String note(){ return note; }
}
