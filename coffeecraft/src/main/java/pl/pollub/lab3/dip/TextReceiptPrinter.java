package pl.pollub.coffeecraft.lab3.dip;

import pl.pollub.coffeecraft.order.Order;

public class TextReceiptPrinter extends AbstractPrinter {

    @Override
    public void print(Order order) {
        System.out.println("Receipt total: " + order.total());
    }
}