package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findProduct(String productName) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst()
                .orElse(null);
    }

    public int productsMinPrice() {
        int minProductPrice = Integer.MAX_VALUE;
        for (Product product : products) {
            if (minProductPrice > product.getPrice()) {
                minProductPrice = product.getPrice();
            }
        }
        return minProductPrice;
    }

    public boolean canPurchase() {
        boolean status = false;
        for (Product product : products) {
            if (product.getQuantity() != 0) {
                status = true;
            }
        }
        return status;
    }
}
