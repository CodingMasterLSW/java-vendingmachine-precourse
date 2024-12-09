package vendingmachine.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.utils.RandomCoin;

public class CoinManager {

    private final Map<Coin, Integer> coinInfo;

    private CoinManager() {
        coinInfo = new LinkedHashMap<>();
        for (Coin coin : Coin.values()) {
            coinInfo.put(coin, 0);
        }
    }

    public static CoinManager create() {
        return new CoinManager();
    }

    public void generateCoins(int amount) {
        int currentAmount = 0;
        while(true) {
            currentAmount = addRandomCoin(amount, currentAmount);
            if (currentAmount == amount) {
                break;
            }
        }
    }

    public Map<Coin, Integer> getCoinInfo() {
        return Collections.unmodifiableMap(coinInfo);
    }

    private int addRandomCoin(int amount, int currentAmount) {
        Coin randomCoin = Coin.getCoinFromAmount(RandomCoin.generate());
        int randomCoinAmount = randomCoin.getAmount();
        if (currentAmount + randomCoinAmount <= amount) {
            currentAmount += randomCoinAmount;
            coinInfo.put(randomCoin, coinInfo.get(randomCoin) + 1);
        }
        return currentAmount;
    }

}
