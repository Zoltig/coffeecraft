package pl.pollub.coffeecraft.behavior.strategy;
public class PercentDiscount implements PricingStrategy {
    private final double percent; // np. 0.10 = 10%
    public PercentDiscount(double percent){ this.percent = percent; }
    @Override public double apply(double baseTotal) { return baseTotal * (1 - percent); }
}