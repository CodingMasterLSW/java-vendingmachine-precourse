package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DELIMITER = ";";
    private static final String SECOND_DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parse(String userInput) {
        List<String> userInputItems = Arrays.asList(userInput.split(DELIMITER));
        return userInputItems;
    }

    public static List<String> substringAndParse(String userInput) {
        String subUserInput = userInput.substring(1, userInput.length() - 1);
        return Arrays.asList(subUserInput.split(SECOND_DELIMITER));
    }

}
