package vendingmachine.domain;

public class VendingMachine {

    private int amount;

    private VendingMachine(int amount) {
        this.amount = amount;
    }

    public static VendingMachine from(int amount) {
        return new VendingMachine(amount);
    }

    public int getAmount() {
        return amount;
    }
}
