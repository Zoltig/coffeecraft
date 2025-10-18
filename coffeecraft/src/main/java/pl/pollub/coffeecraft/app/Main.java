package pl.pollub.coffeecraft.app;

import pl.pollub.coffeecraft.addons.WithExtraShot;
import pl.pollub.coffeecraft.bundle.Bundle;
import pl.pollub.coffeecraft.bundle.SimpleItem;
import pl.pollub.coffeecraft.common.ConfigSingleton;
import pl.pollub.coffeecraft.drink.Drink;
import pl.pollub.coffeecraft.drink.DrinkFactory;
import pl.pollub.coffeecraft.order.Order;
import pl.pollub.coffeecraft.order.OrderBuilder;
import pl.pollub.coffeecraft.payment.PayXAdapter;
import pl.pollub.coffeecraft.payment.PaymentProcessor;
import pl.pollub.coffeecraft.recipe.BaseRecipes;

public class Main {
    public static void main(String[] args) {
        ConfigSingleton.get().setCurrency("PLN");

        Drink latte = new DrinkFactory().create("latte");
        latte = new WithExtraShot(latte);

        var croissant = new SimpleItem("Croissant", 7.0);
        var set = new Bundle("Breakfast Set").add(croissant).add(
                new SimpleItem(latte.name(), latte.cost())
        );

        Order order = new OrderBuilder()
                .withItem(set)
                .withNote("Na wynos")
                .build();

        PaymentProcessor pay = new PayXAdapter();
        System.out.println("Total: " + order.total() + " " + ConfigSingleton.get().currency());
        System.out.println("Paid: " + pay.pay(order.total()));

        // Prototype demo:
        var base = BaseRecipes.houseLatte();
        var mod = base.clone().shots(base.shots()+1);
        System.out.println("Base recipe shots: " + base.shots() + ", Modified: " + mod.shots());
    }
}
