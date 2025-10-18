package pl.pollub.coffeecraft.common;

public class ConfigSingleton {
    private String currency = "PLN";
    private ConfigSingleton() {}
    private static class Holder { static final ConfigSingleton I = new ConfigSingleton(); }
    public static ConfigSingleton get() { return Holder.I; }
    public String currency() { return currency; }
    public void setCurrency(String c) { this.currency = c; }
}
