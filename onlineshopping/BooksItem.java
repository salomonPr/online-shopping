package onlineshopping;

public class BooksItem extends ShoppingItem {
    private String isbn;
    private String edition;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String isbn, String edition) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.isbn = isbn;
        this.edition = edition;
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
            customer.getCart().addItem(this);
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for Book: " + itemName + " | Edition: " + edition);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && isbn.length() == 13;
    }
}

