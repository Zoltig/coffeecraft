package pl.pollub.coffeecraft.behavior.strategy;
public interface PricingStrategy {
    double apply(double baseTotal);
}