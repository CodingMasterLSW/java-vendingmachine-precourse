package vendingmachine.exception;

public enum ErrorMessage {
    NOT_BLANK_INPUT("입력은 공백일 수 없습니다. 다시 입력해주세요."),
    NOT_NUMBER("양의 정수만 입력 가능합니다. 다시 입력해주세요."),
    NOT_PERMIT_ONE_DIGIT("금액은 10원 단위로 입력 가능합니다. 다시 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
