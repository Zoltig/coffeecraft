package pl.pollub.coffeecraft.lab4.functional;

@FunctionalInterface
public interface PriceModifier {
    double apply(double price);
}