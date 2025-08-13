package onlineshopping;

public class ElectronicsItem extends ShoppingItem {
    private int warrantyYears;

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyYears) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyYears = warrantyYears;
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
            System.out.println(itemName + " added to cart.");
            customer.getCart().addItem(this);
        }
    }

    @Override
    public void generateInvoice(Customer customer) {

        System.out.println("Generating invoice for " + itemName);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && price > 0;
    }
}

