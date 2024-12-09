package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DELIMITER = ";";

    private InputParser() {
    }

    public static List<String> parse(String userInput) {
        List<String> userInputItems = Arrays.asList(userInput.split(DELIMITER));
        return userInputItems;
    }

}
