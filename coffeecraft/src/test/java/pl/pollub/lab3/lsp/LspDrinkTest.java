package pl.pollub.coffeecraft.lab3.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LspDrinkTest {

    @Test
    void latteDrinkCanSubstituteBasicDrink() {
        BasicDrink drink = new LatteDrink(); // LSP – używamy podklasy

        assertEquals("Latte", drink.name());
        assertEquals(8.0, drink.cost());
    }
}