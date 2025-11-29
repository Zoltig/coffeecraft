package pl.pollub.coffeecraft.lab3.dip;

public abstract class AbstractNotifier implements Notifier {
    @Override
    public abstract void send(String message);
}