package common.storage;

import common.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartStorage {
    private static final List<Product> cartItems = new ArrayList<>();

    public static void addProduct(Product product) {
        cartItems.add(product);
    }

    public static List<Product> getCartItems() {
        return cartItems;
    }

    public static void removeProduct(Product productToDelete) {
        cartItems.remove(productToDelete);
    }

    public static void clear() {
        cartItems.clear();
    }
}
