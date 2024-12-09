package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
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
            String subInputProduct = inputProduct.substring(1, inputProduct.length() - 1);
            List<String> splitProductInfo = Arrays.asList(subInputProduct.split(","));
            String name = splitProductInfo.get(0);
            int price = Integer.parseInt(splitProductInfo.get(1));
            int quantity = Integer.parseInt(splitProductInfo.get(2));
            Product product = Product.of(name, price, quantity);
            products.addProduct(product);
        }
        return products;
    }

    public Insert createPurchase(int inputPrice) {
        return Insert.from(inputPrice);
    }

}
