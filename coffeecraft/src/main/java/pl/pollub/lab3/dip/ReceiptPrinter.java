package pl.pollub.coffeecraft.lab3.dip;

import pl.pollub.coffeecraft.order.Order;

public interface ReceiptPrinter {
    void print(Order order);
}