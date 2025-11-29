package pl.pollub.coffeecraft.lab3.isp;

public interface MachineServiceOperations {
    void start();
    void stop();
    void calibrate();
    void wash();
    void fullDiagnostics();
}