package pl.pollub.coffeecraft.lab4.functional;

import org.junit.jupiter.api.Test;
import pl.pollub.coffeecraft.bundle.SimpleItem;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalDemoTest {

    @Test
    void testPriceModifier() {
        var demo = new FunctionalDemo();
        double result = demo.modifyPrice(10.0, p -> p * 1.20); // +20%
        assertEquals(12.0, result);
    }

    @Test
    void testNameFormatter() {
        var demo = new FunctionalDemo();
        String result = demo.formatName("latte", n -> n.toUpperCase());
        assertEquals("LATTE", result);
    }

    @Test
    void testItemFilter() {
        var demo = new FunctionalDemo();

        var list = List.of(
                new SimpleItem("Croissant", 7.0),
                new SimpleItem("Latte", 15.0)
        );

        var filtered = demo.filterItems(list, i -> i.price() > 10);

        assertEquals(1, filtered.size());
        assertEquals("Latte", filtered.get(0).name());
    }
}