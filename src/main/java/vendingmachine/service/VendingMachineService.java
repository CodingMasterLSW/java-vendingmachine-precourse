package vendingmachine.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinManager;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.Insert;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.InputParser;

public class VendingMachineService {

    public VendingMachine createVendingMachine(int coinAmount) {
        return VendingMachine.from(coinAmount);
    }

    public Products createProducts(String userInput) {
        Products products = Products.create();
        List<String> inputProducts = InputParser.parse(userInput);
        for (String inputProduct : inputProducts) {
            List<String> splitProductInfo = InputParser.substringAndParse(inputProduct);
            Product product = createProduct(splitProductInfo);
            products.addProduct(product);
        }
        return products;
    }

    public Insert createPurchase(int inputPrice) {
        return Insert.from(inputPrice);
    }

    public Map<Coin, Integer> generateCoin(VendingMachine vendingMachine) {
        CoinManager coinManager = CoinManager.create();
        coinManager.generateCoins(vendingMachine.getAmount());
        return coinManager.getCoinInfo();
    }

    public void purchaseProduct(String purchaseItemName, Products products, Insert insert) {
        Product product = products.findProduct(purchaseItemName);
        insert.decreaseAmount(product);
        product.decreaseQuantity();
    }

    public Map<Coin, Integer> calculateChange(Map<Coin, Integer> coinInfo, int leftAmount) {
        Map<Coin, Integer> results = new LinkedHashMap<>();
        for (Coin coin : coinInfo.keySet()) {
            addChangeResult(coinInfo, leftAmount, coin, results);
        }
        return results;
    }

    private void addChangeResult(Map<Coin, Integer> coinInfo, int leftAmount, Coin coin,
            Map<Coin, Integer> results) {
        int coinQuantity = coinInfo.get(coin);
        while (coin.getAmount() <= leftAmount && coinQuantity != 0) {
            leftAmount -= coin.getAmount();
            results.put(coin, results.getOrDefault(coin, 0) + 1);
            coinQuantity--;
        }
    }

    private Product createProduct(List<String> splitProductInfo) {
        String name = splitProductInfo.get(0);
        int price = Integer.parseInt(splitProductInfo.get(1));
        int quantity = Integer.parseInt(splitProductInfo.get(2));
        return Product.of(name, price, quantity);
    }
}
