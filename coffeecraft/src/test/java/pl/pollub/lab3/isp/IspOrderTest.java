package pl.pollub.coffeecraft.lab3.isp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class IspOrderTest {

    @Test
    void restaurantOrderUsesSegregatedInterfaces() {
        RestaurantOrder order = new RestaurantOrder();

        assertDoesNotThrow(() -> {
            order.addItem();
            order.pay();
            order.printReceipt();
        });
    }
}