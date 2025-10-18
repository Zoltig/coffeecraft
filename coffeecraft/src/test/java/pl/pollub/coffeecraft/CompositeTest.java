package pl.pollub.coffeecraft;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.pollub.coffeecraft.bundle.*;
import pl.pollub.coffeecraft.drink.*;

class CompositeTest {

    @Test
    void bundlePriceIsSumOfItems() {
        // Drink -> Component poprzez SimpleItem (nazwa + koszt)
        Espresso espressoDrink = new Espresso();
        Component espresso = new SimpleItem(espressoDrink.name(), espressoDrink.cost());

        Component croissant = new SimpleItem("Croissant", 7.0);

        Bundle breakfastSet = new Bundle("Breakfast Set")
                .add(espresso)
                .add(croissant);

        double expected = espresso.price() + croissant.price();
        assertEquals(expected, breakfastSet.price(), 1e-6,
                "Cena zestawu powinna być sumą składników");
    }
}
