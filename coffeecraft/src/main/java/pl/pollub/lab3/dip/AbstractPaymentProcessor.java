package pl.pollub.coffeecraft.lab3.dip;

public abstract class AbstractPaymentProcessor implements PaymentProcessor {
    @Override
    public abstract void pay(double amount);
}