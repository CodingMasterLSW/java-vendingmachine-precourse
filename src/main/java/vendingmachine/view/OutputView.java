package vendingmachine.view;

import java.util.Map;

public class OutputView {

    private static final String VENDING_MACHINE_HAS_COIN_MESSAGE = "자판기가 보유한 동전";
    private static final String VENDING_MACHINE_COIN = "%s원 - %s개";
    private static final String BLANK = "";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printGenerateCoin(Map<Integer, Integer> coinInfo) {
        for (Integer key : coinInfo.keySet()) {
            System.out.printf(VENDING_MACHINE_COIN, key, coinInfo.get(key));
            printMessage(BLANK);
        }

    }

    public void printVendingMachineCoinMessage() {
        printMessage(BLANK);
        printMessage(VENDING_MACHINE_HAS_COIN_MESSAGE);
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
