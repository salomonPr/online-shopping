package onlineshopping;


import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private LocalDate expirationDate;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expirationDate) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
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
        System.out.println("Invoice for Grocery Item: " + itemName);
    }

    @Override
    public boolean validateItem() {
        return expirationDate.isAfter(LocalDate.now());
    }
}

