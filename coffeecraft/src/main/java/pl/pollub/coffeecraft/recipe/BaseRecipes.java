package pl.pollub.coffeecraft.recipe;

public class BaseRecipes {
    private BaseRecipes(){}

    public static RecipePrototype houseLatte() {
        return new RecipePrototype("espresso", true, 1);
    }

    public static RecipePrototype flatWhite() {
        return new RecipePrototype("espresso", true, 2);
    }
}
