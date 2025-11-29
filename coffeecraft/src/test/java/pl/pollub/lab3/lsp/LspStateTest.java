package pl.pollub.coffeecraft.lab3.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LspStateTest {

    @Test
    void paidStateCanSubstituteOrderState() {
        OrderState state = new PaidLspState(); // podklasa zamiast bazowej

        assertEquals("Paid", state.status());
    }
}