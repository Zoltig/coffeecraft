package pl.pollub.coffeecraft.behavior.observer;
public interface OrderObserver { void onEvent(OrderEvent event, String message); }