package vendingmachine.view;

import static vendingmachine.exception.ErrorMessage.NOT_BLANK_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String COIN_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public void printCoinInputMessage() {
        printMessage(COIN_INPUT_MESSAGE);
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

}
