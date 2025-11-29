package pl.pollub.coffeecraft.lab3.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LspItemTest {

    @Test
    void croissantItemCanSubstituteBaseItem() {
        BaseItem item = new CroissantItem();

        assertEquals("Croissant", item.name());
        assertEquals(7.0, item.price());
    }
}