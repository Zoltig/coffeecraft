package pl.pollub.coffeecraft.behavior.command;
import java.util.ArrayList; import java.util.List;
public class OrderInvoker {
    private final List<Command> history = new ArrayList<>();
    public void run(Command c){ c.execute(); history.add(c); }
    public int historySize(){ return history.size(); }
}