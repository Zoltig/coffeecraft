package pl.pollub.coffeecraft.app;

import pl.pollub.coffeecraft.addons.WithExtraShot;
import pl.pollub.coffeecraft.bundle.*;
import pl.pollub.coffeecraft.common.ConfigSingleton;
import pl.pollub.coffeecraft.drink.*;
import pl.pollub.coffeecraft.order.*;
import pl.pollub.coffeecraft.payment.*;
import pl.pollub.coffeecraft.recipe.*;

import pl.pollub.coffeecraft.behavior.strategy.*;
import pl.pollub.coffeecraft.behavior.command.*;
import pl.pollub.coffeecraft.behavior.state.*;
import pl.pollub.coffeecraft.behavior.observer.*;
import pl.pollub.coffeecraft.behavior.iterator.*;
import pl.pollub.coffeecraft.behavior.mediator.*;
import pl.pollub.coffeecraft.behavior.memento.*;

public class Main {
    public static void main(String[] args) {

        ConfigSingleton.get().setCurrency("PLN");
        Drink latte = new DrinkFactory().create("latte");
        latte = new WithExtraShot(latte);

        var croissant = new SimpleItem("Croissant", 7.0);
        var set = new Bundle("Breakfast Set")
                .add(croissant)
                .add(new SimpleItem(latte.name(), latte.cost()));

        Order order = new OrderBuilder()
                .withItem(set)
                .withNote("Na wynos")
                .build();

        PaymentProcessor pay = new PayXAdapter();


        // ---------- STRATEGY ----------
        var pricer = new OrderPricer();
        System.out.println("Total (no discount): " + pricer.total(order));
        pricer.setStrategy(new PercentDiscount(0.1));
        System.out.println("Total (10% off): " + pricer.total(order));


        // ---------- OBSERVER + MEDIATOR ----------
        var publisher = new OrderPublisher();
        publisher.add(new ConsoleObserver());

        var mediator = new OrderMediator(pay, publisher);
        System.out.println("Paid via mediator: " + mediator.checkout(order));


        // ---------- STATE ----------
        var lifecycle = new OrderLifecycle();
        System.out.println("State: " + lifecycle.state());
        lifecycle.pay();
        System.out.println("State: " + lifecycle.state());
        lifecycle.serve();
        System.out.println("State: " + lifecycle.state());


        // ---------- ITERATOR ----------
        var it = new OrderIterator(order.items());
        System.out.println("Iterator:");
        while(it.hasNext()) {
            System.out.println(" - " + it.next().name());
        }


        // ---------- MEMENTO ----------
        var editor = new OrderEditor();
        editor.add(croissant);
        editor.note("Na miejscu");

        var caretaker = new OrderCaretaker();
        caretaker.push(editor.snapshot());

        editor.note("Na wynos");
        editor.restore(caretaker.pop());

        System.out.println("Restored note -> " + editor.build().note());
    }
}
