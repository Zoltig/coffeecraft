package pl.pollub.coffeecraft.payment;

import java.math.BigDecimal;

public class PayYAdapter implements PaymentProcessor {
    private final ExternalPayY y = new ExternalPayY();
    @Override public boolean pay(double amount) {
        return y.makePayment(BigDecimal.valueOf(amount));
    }
}
