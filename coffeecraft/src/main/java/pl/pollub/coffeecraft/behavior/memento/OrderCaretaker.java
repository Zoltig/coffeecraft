package pl.pollub.coffeecraft.behavior.memento;
import java.util.ArrayDeque; import java.util.Deque;
public class OrderCaretaker {
    private final Deque<OrderMemento> stack = new ArrayDeque<>();
    public void push(OrderMemento m){ stack.push(m); }
    public OrderMemento pop(){ return stack.pop(); }
}