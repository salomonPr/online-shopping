package onlineshopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    List<ShoppingItem> cartItems;
    private double totalPrice;
    private Customer customer;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.cartItems = new ArrayList<>();
        this.cartId = "CART-" + System.currentTimeMillis();
    }

    public void addItem(ShoppingItem item) {
        if (item.validateItem()) {
            cartItems.add(item);
            totalPrice += item.price;
            item.updateStock(1);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

