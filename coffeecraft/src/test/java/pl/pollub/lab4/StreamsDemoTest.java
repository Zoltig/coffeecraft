package pl.pollub.coffeecraft.lab4.streams;

import org.junit.jupiter.api.Test;
import pl.pollub.coffeecraft.bundle.SimpleItem;
import pl.pollub.coffeecraft.order.Order;
import pl.pollub.coffeecraft.order.OrderBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamsDemoTest {

    @Test
    void testSumPrices(){
        var demo = new StreamsDemo();
        double result = demo.sumPrices(List.of(2.0, 3.0, 5.0));
        assertEquals(10.0, result);
    }

    @Test
    void testExpensive(){
        var demo = new StreamsDemo();
        var result = demo.expensiveItems(List.of(
                new SimpleItem("A", 5),
                new SimpleItem("B", 20)
        ));
        assertEquals(1, result.size());
        assertEquals("B", result.get(0).name());
    }

    @Test
    void testOrderTotals(){
        var demo = new StreamsDemo();

        Order o1 = new OrderBuilder().withItem(new SimpleItem("X", 5)).build();
        Order o2 = new OrderBuilder().withItem(new SimpleItem("Y", 15)).build();

        var totals = demo.orderTotals(List.of(o1, o2));
        assertEquals(List.of(5.0, 15.0), totals);
    }
}