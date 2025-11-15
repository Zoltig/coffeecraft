package pl.pollub.coffeecraft.behavior.strategy;
import pl.pollub.coffeecraft.order.Order;

public class OrderPricer {
    private PricingStrategy strategy = new NoDiscount();
    public void setStrategy(PricingStrategy s) { this.strategy = s; }
    public double total(Order order) { return strategy.apply(order.total()); }
}