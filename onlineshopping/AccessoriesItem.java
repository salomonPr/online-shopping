package onlineshopping;


import java.util.ArrayList;
import java.util.List;

public class AccessoriesItem extends ShoppingItem {
    private List<String> reviews = new ArrayList<>();
    private List<Integer> ratings = new ArrayList<>();

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer) {
        if (validateItem()) {
            customer.getCart().addItem(this);
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for Accessory: " + itemName);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }

    public void addReview(String review, int rating) {
        reviews.add(review);
        ratings.add(rating);
    }
}

