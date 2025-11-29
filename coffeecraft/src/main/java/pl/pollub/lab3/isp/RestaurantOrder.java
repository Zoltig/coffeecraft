package pl.pollub.coffeecraft.lab3.isp;

public class RestaurantOrder implements OrderModification, OrderPayment, OrderPrinting {

    @Override
    public void addItem() {
        System.out.println("Item added to restaurant order");
    }

    @Override
    public void removeItem() {
        System.out.println("Item removed from restaurant order");
    }

    @Override
    public void pay() {
        System.out.println("Restaurant order paid");
    }

    @Override
    public void printReceipt() {
        System.out.println("Restaurant order receipt printed");
    }
}