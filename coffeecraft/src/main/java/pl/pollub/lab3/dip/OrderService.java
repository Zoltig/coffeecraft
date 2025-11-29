package pl.pollub.coffeecraft.lab3.dip;

import pl.pollub.coffeecraft.order.Order;

public class OrderService {

    private final PaymentProcessor paymentProcessor;
    private final ReceiptPrinter receiptPrinter;
    private final Notifier notifier;

    public OrderService(PaymentProcessor paymentProcessor,
                        ReceiptPrinter receiptPrinter,
                        Notifier notifier) {
        this.paymentProcessor = paymentProcessor;
        this.receiptPrinter = receiptPrinter;
        this.notifier = notifier;
    }

    public void complete(Order order) {
        paymentProcessor.pay(order.total());
        receiptPrinter.print(order);
        notifier.send("Order completed with total: " + order.total());
    }
}