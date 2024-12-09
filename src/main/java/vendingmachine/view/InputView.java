package vendingmachine.view;

import static vendingmachine.exception.ErrorMessage.NOT_BLANK_INPUT;
import static vendingmachine.exception.ErrorMessage.NOT_NUMBER;
import static vendingmachine.exception.ErrorMessage.NOT_PERMIT_ONE_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern NUMBER = Pattern.compile("\\d+");
    private static final String COIN_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String PRODUCT_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String BLANK = "";
    private static final int MIN_DIGIT = 10;

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public void printCoinInputMessage() {
        printMessage(COIN_INPUT_MESSAGE);
    }

    public void printProductInputMessage() {
        printMessage(BLANK);
        printMessage(PRODUCT_INPUT_MESSAGE);
    }

    public int coinInput() {
        String userInput = userInput();
        validateNumber(userInput);
        validateNumberAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public String userInput() {
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void validateInput(String userInput) {
        if (userInput.isEmpty() || userInput == null) {
            throw new IllegalArgumentException(NOT_BLANK_INPUT.getMessage());
        }
    }

    private void validateNumber(String userInput) {
        if (!NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private void validateNumberAmount(String userInput) {
        int convertUserInput = Integer.parseInt(userInput);
        if (convertUserInput % MIN_DIGIT != 0) {
            throw new IllegalArgumentException(NOT_PERMIT_ONE_DIGIT.getMessage());
        }
    }

}
