package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private final List<Product> products;

    private Products() {
        this.products = new ArrayList<>();
    }

    public static Products create() {
        return new Products();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProduct(String productName) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst()
                .orElse(null);
    }

    public int productsMinPrice() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    public boolean canPurchase() {
        return products.stream()
                .anyMatch(product -> product.getQuantity() != 0);
    }
}
