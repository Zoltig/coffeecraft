package pl.pollub.coffeecraft.lab3.dip;

import pl.pollub.coffeecraft.order.Order;

public abstract class AbstractPrinter implements ReceiptPrinter {
    @Override
    public abstract void print(Order order);
}