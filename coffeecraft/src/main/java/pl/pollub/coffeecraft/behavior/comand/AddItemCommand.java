package pl.pollub.coffeecraft.behavior.command;
import pl.pollub.coffeecraft.order.Order;
import pl.pollub.coffeecraft.bundle.Component;

public class AddItemCommand implements Command {
    private final Order mutableOrder; private final Component item;
    public AddItemCommand(Order mutableOrder, Component item){
        this.mutableOrder = mutableOrder; this.item = item;
    }
    @Override public void execute() { mutableOrder.items().add(item); }
}