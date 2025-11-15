package pl.pollub.coffeecraft.behavior.mediator;
import pl.pollub.coffeecraft.order.Order;
import pl.pollub.coffeecraft.payment.PaymentProcessor;
import pl.pollub.coffeecraft.behavior.observer.*;

public class OrderMediator {
    private final PaymentProcessor payment;
    private final OrderPublisher publisher;

    public OrderMediator(PaymentProcessor payment, OrderPublisher publisher){
        this.payment = payment; this.publisher = publisher;
    }

    public boolean checkout(Order order){
        boolean ok = payment.pay(order.total());
        if (ok) publisher.publish(OrderEvent.PAID, "Order paid: " + order.total());
        return ok;
    }
}