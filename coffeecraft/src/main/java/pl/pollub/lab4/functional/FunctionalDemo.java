package pl.pollub.coffeecraft.lab4.functional;

import pl.pollub.coffeecraft.bundle.Component;

import java.util.List;

public class FunctionalDemo {

    public interface PriceModifier {
        double apply(double price);
    }

    public interface NameFormatter {
        String apply(String name);
    }

    public interface ItemFilter {
        boolean accept(Component item);
    }

    public double modifyPrice(double price, PriceModifier modifier) {
        return modifier.apply(price);
    }

    public String formatName(String name, NameFormatter formatter) {
        return formatter.apply(name);
    }

    public <T extends Component> List<T> filterItems(List<T> items, ItemFilter filter) {
        return items.stream()
                .filter(filter::accept)
                .toList();
    }
}