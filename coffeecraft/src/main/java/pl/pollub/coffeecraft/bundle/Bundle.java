package pl.pollub.coffeecraft.bundle;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements Component {
    private final String name;
    private final List<Component> children = new ArrayList<>();
    public Bundle(String name) { this.name = name; }
    public Bundle add(Component c) { children.add(c); return this; }
    @Override public String name() { return name; }
    @Override public double price() { return children.stream().mapToDouble(Component::price).sum(); }
}
