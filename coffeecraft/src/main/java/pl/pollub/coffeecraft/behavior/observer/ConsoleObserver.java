package pl.pollub.coffeecraft.behavior.observer;
public class ConsoleObserver implements OrderObserver {
    @Override public void onEvent(OrderEvent event, String message){
        System.out.println("[OBS] " + event + " -> " + message);
    }
}