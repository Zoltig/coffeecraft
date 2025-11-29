package pl.pollub.coffeecraft.lab3.lsp;

public class PaidLspState extends OrderState {
    @Override
    public String status() {
        return "Paid";
    }
}