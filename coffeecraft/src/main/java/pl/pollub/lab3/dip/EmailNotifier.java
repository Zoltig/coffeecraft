package pl.pollub.coffeecraft.lab3.dip;

public class EmailNotifier extends AbstractNotifier {

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}