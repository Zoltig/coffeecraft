package pl.pollub.coffeecraft.recipe;

public class RecipePrototype implements Cloneable {
    private String base;     // np. "espresso"
    private boolean milk;    // czy mleko
    private int shots;       // liczba shotów

    public RecipePrototype(String base, boolean milk, int shots) {
        this.base = base; this.milk = milk; this.shots = shots;
    }

    @Override public RecipePrototype clone() {
        try { return (RecipePrototype) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }

    // gettery/settery fluent (wystarczy na demo)
    public String base() { return base; }
    public boolean milk() { return milk; }
    public int shots() { return shots; }

    public RecipePrototype base(String b){ this.base=b; return this; }
    public RecipePrototype milk(boolean m){ this.milk=m; return this; }
    public RecipePrototype shots(int s){ this.shots=s; return this; }
}
