package vendingmachine.view;

import java.util.Map;

public class OutputView {

    private static final String VENDING_MACHINE_HAS_COIN_MESSAGE = "자판기가 보유한 동전";
    private static final String CHANGE = "잔돈";
    private static final String COIN_RESULT = "%s원 - %s개";
    private static final String INSERT_AMOUNT = "투입 금액: %s원";
    private static final String BLANK = "";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printGenerateCoin(Map<Integer, Integer> coinInfo) {
        for (Integer key : coinInfo.keySet()) {
            System.out.printf(COIN_RESULT, key, coinInfo.get(key));
            printMessage(BLANK);
        }
    }

    public void printInsertAmount(int insertAmount) {
        printMessage(BLANK);
        System.out.printf(INSERT_AMOUNT, insertAmount);
        printMessage(BLANK);
    }

    public void printVendingMachineCoinMessage() {
        printMessage(BLANK);
        printMessage(VENDING_MACHINE_HAS_COIN_MESSAGE);
    }

    public void printChange(Map<Integer, Integer> changeResult) {
        printMessage(CHANGE);
        for (Integer coin : changeResult.keySet()) {
            System.out.printf(COIN_RESULT, coin, changeResult.get(coin));
            printMessage(BLANK);
        }

    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
