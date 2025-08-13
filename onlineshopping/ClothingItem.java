package onlineshopping;

public class ClothingItem extends ShoppingItem {
    private String size;
    private boolean isSeasonal;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String size, boolean isSeasonal) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.size = size;
        this.isSeasonal = isSeasonal;
    }

    public void setSize(String size) {
        this.size = size.toUpperCase();
    }

    @Override
    public void updateStock(int quantity) {
        if (quantity <= stockAvailable) {
            stockAvailable -= quantity;
        } else {
            System.out.println("Not enough stock for " + itemName);
        }
    }

    @Override
    public void addToCart(Customer customer) {
        if (validateItem()) {
            double discountedPrice = isSeasonal ? price * 0.9 : price; // 10% discount if seasonal
            System.out.println("Adding " + itemName + " (Size: " + size + ") to cart.");
            System.out.printf("Price: $%.2f %s\n", discountedPrice, isSeasonal ? "(10% seasonal discount applied)" : "");
            customer.getCart().addItem(this);
        } else {
            System.out.println("Item validation failed. Could not add to cart.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        double discountedPrice = isSeasonal ? price * 0.9 : price;
        System.out.println("Invoice for Clothing Item: " + itemName + " | Size: " + size);
        System.out.printf("Price: $%.2f\n", discountedPrice);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && size != null && size.matches("(?i)S|M|L|XL");
    }
}


