package vendingmachine.domain;

public class Purchase {

    private int inputAmount;

    private Purchase(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public static Purchase from(int inputAmount) {
        return new Purchase(inputAmount);
    }

    public void decreaseAmount(Product product) {
        this.inputAmount -= product.getPrice();
    }

}
