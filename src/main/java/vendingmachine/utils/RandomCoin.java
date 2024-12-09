package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.Coin;

public class RandomCoin {

    private RandomCoin() {
    }

    public static int generate() {
        List<Integer> coins = Arrays.stream(Coin.values())
                .map(coin -> coin.getAmount())
                .collect(Collectors.toList());
        return Randoms.pickNumberInList(coins);
    }
}
