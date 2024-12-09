package vendingmachine.domain;

public class Insert {

    private int inputAmount;

    private Insert(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public static Insert from(int inputAmount) {
        return new Insert(inputAmount);
    }

    public void decreaseAmount(Product product) {
        this.inputAmount -= product.getPrice();
    }



}
