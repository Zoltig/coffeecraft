package pl.pollub.coffeecraft;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.pollub.coffeecraft.recipe.*;

class PrototypeTest {

    @Test
    void clonedRecipeIsIndependent() {
        RecipePrototype base = BaseRecipes.houseLatte();
        RecipePrototype modified = base.clone().shots(base.shots() + 1);

        assertNotEquals(base.shots(), modified.shots(),
                "Kopia przepisu powinna być niezależna od oryginału");
    }
}
