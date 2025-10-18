package pl.pollub.coffeecraft.drink;

public class DrinkFactory {
    public Drink create(String type) {
        return switch (type.toLowerCase()) {
            case "espresso" -> new Espresso();
            case "americano" -> new Americano();
            case "latte" -> new Latte();
            default -> throw new IllegalArgumentException("Unknown drink: " + type);
        };
    }
}
