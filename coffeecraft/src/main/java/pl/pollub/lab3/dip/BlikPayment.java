package pl.pollub.coffeecraft.lab3.dip;

public class BlikPayment extends AbstractPaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid with BLIK: " + amount);
    }
}