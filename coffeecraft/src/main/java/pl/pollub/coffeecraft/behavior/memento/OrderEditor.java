package pl.pollub.coffeecraft.behavior.memento;
import pl.pollub.coffeecraft.order.Order;
import pl.pollub.coffeecraft.bundle.Component;
import java.util.ArrayList;
public class OrderEditor {
    private final ArrayList<Component> items = new ArrayList<>();
    private String note = "";
    public void add(Component c){ items.add(c); }
    public void note(String n){ note=n; }
    public OrderMemento snapshot(){ return new OrderMemento(new ArrayList<>(items), note); }
    public void restore(OrderMemento m){ items.clear(); items.addAll(m.items()); note=m.note(); }
    public Order build(){ return new pl.pollub.coffeecraft.order.Order(items, note); } // ewent. konstruktor publiczny
}