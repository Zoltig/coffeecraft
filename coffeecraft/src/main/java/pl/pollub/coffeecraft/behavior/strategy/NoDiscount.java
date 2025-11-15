package pl.pollub.coffeecraft.behavior.strategy;
public class NoDiscount implements PricingStrategy {
    @Override public double apply(double baseTotal) { return baseTotal; }
}