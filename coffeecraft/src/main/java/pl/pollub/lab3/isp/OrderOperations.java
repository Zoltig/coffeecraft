package pl.pollub.coffeecraft.lab3.isp;

public interface OrderOperations {
    void addItem();
    void removeItem();
    void pay();
    void cancel();
    void printReceipt();
}