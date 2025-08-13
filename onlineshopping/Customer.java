package onlineshopping;

public class Customer {
    private String customerId, customerName, email, address, phone;
    private ShoppingCart cart;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cart = new ShoppingCart(this);
    }

    public boolean validateCustomer() {
        return email.contains("@") && address.length() > 5 && phone.matches("\\d{10}");
    }

    public ShoppingCart getCart() {
        return cart;
    }
}

