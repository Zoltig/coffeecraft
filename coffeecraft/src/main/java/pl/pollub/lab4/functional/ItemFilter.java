package pl.pollub.coffeecraft.lab4.functional;

import pl.pollub.coffeecraft.bundle.Component;

@FunctionalInterface
public interface ItemFilter {
    boolean accept(Component c);
}