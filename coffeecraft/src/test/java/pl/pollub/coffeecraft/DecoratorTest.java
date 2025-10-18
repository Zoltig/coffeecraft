package pl.pollub.coffeecraft;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.pollub.coffeecraft.drink.*;
import pl.pollub.coffeecraft.addons.*;

class DecoratorTest {

    @Test
    void latteWithExtraShotCostsMore() {
        Drink latte = new Latte();
        Drink latteWithShot = new WithExtraShot(latte);

        assertTrue(latteWithShot.cost() > latte.cost(),
                "Latte z dodatkowym shotem powinno być droższe niż zwykłe Latte");
    }
}
