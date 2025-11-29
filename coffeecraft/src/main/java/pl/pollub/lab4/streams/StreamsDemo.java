package pl.pollub.coffeecraft.lab4.streams;

import pl.pollub.coffeecraft.bundle.Component;
import pl.pollub.coffeecraft.order.Order;

import java.util.List;

public class StreamsDemo {

    // 1. sumowanie cen (reduce) (funkcyjne sumowanie kolekcji liczb)
    public double sumPrices(List<Double> prices){
        return prices.stream().reduce(0.0, Double::sum);
    }

    // 2. filtrowanie (filter) odpowiednich komponentów (filtrowanie kolekcji obiektów )
    public List<Component> expensiveItems(List<Component> items){
        return items.stream()
                .filter(i -> i.price() > 10)
                .toList();
    }

    // 3. mapowanie (map) zamówień na sumy (mapowanie kolekcji obiektów na kolekcję wartości liczbowych)
    public List<Double> orderTotals(List<Order> orders){
        return orders.stream()
                .map(Order::total)
                .toList();
    }
}