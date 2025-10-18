package pl.pollub.coffeecraft;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.pollub.coffeecraft.payment.*;

class AdapterTest {

    @Test
    void payXAdapterAlwaysReturnsTrue() {
        PaymentProcessor payX = new PayXAdapter();
        assertTrue(payX.pay(10.0), "PayXAdapter powinien zwrócić true dla płatności");
    }

    @Test
    void payYAdapterAlwaysReturnsTrue() {
        PaymentProcessor payY = new PayYAdapter();
        assertTrue(payY.pay(15.0), "PayYAdapter powinien zwrócić true dla płatności");
    }
}
