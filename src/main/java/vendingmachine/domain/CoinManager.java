package vendingmachine.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.utils.RandomCoin;

public class CoinManager {

    private final Map<Integer, Integer> coinInfo;

    private CoinManager() {
        coinInfo = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            coinInfo.put(coin.getAmount(), 0);
        }
    }

    public static CoinManager create() {
        return new CoinManager();
    }

    public void generateCoin(int amount) {
        int currentAmount = 0;
        while(true) {
            int randomCoin = RandomCoin.generate();
            if (currentAmount+randomCoin <= amount) {
                currentAmount += randomCoin;
                coinInfo.put(randomCoin, coinInfo.get(randomCoin) + 1);
            }
            if (currentAmount == amount) {
                break;
            }
        }
    }

    public Map<Integer, Integer> getCoinInfo() {
        return Collections.unmodifiableMap(coinInfo);
    }

}
