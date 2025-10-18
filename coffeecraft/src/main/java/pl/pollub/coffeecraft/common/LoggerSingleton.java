package pl.pollub.coffeecraft.common;

public class LoggerSingleton {
    private LoggerSingleton() {}
    private static class Holder { static final LoggerSingleton I = new LoggerSingleton(); }
    public static LoggerSingleton get() { return Holder.I; }
    public void info(String msg) { System.out.println("[INFO] " + msg); }
}
