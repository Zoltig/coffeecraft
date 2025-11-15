package pl.pollub.coffeecraft.behavior.observer;
import java.util.*;
public class OrderPublisher {
    private final List<OrderObserver> obs = new ArrayList<>();
    public void add(OrderObserver o){ obs.add(o); }
    public void publish(OrderEvent e, String msg){ obs.forEach(o -> o.onEvent(e,msg)); }
}