package pl.pollub.coffeecraft.payment;

public interface PaymentProcessor {
    boolean pay(double amount);
}
