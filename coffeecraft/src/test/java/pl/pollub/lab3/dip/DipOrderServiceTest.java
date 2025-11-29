package pl.pollub.coffeecraft.lab3.dip;

import org.junit.jupiter.api.Test;
import pl.pollub.coffeecraft.bundle.SimpleItem;
import pl.pollub.coffeecraft.order.OrderBuilder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DipOrderServiceTest {

    @Test
    void orderServiceUsesAbstractionsNotImplementations() {
        var order = new OrderBuilder()
                .withItem(new SimpleItem("Latte", 10.0))
                .build();

        PaymentProcessor payment = new BlikPayment();
        ReceiptPrinter printer = new TextReceiptPrinter();
        Notifier notifier = new EmailNotifier();

        OrderService service = new OrderService(payment, printer, notifier);

        assertDoesNotThrow(() -> service.complete(order));
    }
}