package pl.pollub.coffeecraft.payment;

public class PayXAdapter implements PaymentProcessor {
    private final ExternalPayX x = new ExternalPayX();
    @Override public boolean pay(double amount) {
        int cents = (int) Math.round(amount * 100);
        return x.charge(cents);
    }
}
