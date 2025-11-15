package pl.pollub.coffeecraft.behavior.iterator;
import pl.pollub.coffeecraft.bundle.Component;
import java.util.Iterator; import java.util.List;

public class OrderIterator implements Iterator<Component> {
    private final List<Component> items; private int idx=0;
    public OrderIterator(List<Component> items){ this.items = items.stream()
            .sorted((a,b) -> Double.compare(b.price(), a.price())).toList(); }
    @Override public boolean hasNext(){ return idx < items.size(); }
    @Override public Component next(){ return items.get(idx++); }
}