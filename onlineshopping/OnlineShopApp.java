package onlineshopping;

     import java.time.LocalDate;
import java.util.Scanner;

    public class OnlineShopApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // === Customer Details ===
            System.out.println("=== Enter Customer Information ===");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Phone (10 digits): ");
            String phone = sc.nextLine();

            Customer customer = new Customer("CUST001", name, email, address, phone);
            if (!customer.validateCustomer()) {
                System.out.println("Invalid customer information. Exiting.");
                return;
            }

            // === Sample Products ===
            ShoppingItem[] products = {
                    new ElectronicsItem("E001", "Laptop", "Gaming Laptop", 1200.0, 5, 2),
                    new ClothingItem("C001", "Jacket", "Winter Jacket", 80.0, 10, "M", true),
                    new GroceriesItem("G001", "Rice Bag", "5kg Basmati", 15.0, 50, LocalDate.now().plusDays(30)),
                    new BooksItem("B001", "Java Basics", "Programming Guide", 35.0, 20, "9781234567890", "2nd Edition"),
                    new AccessoriesItem("A001", "Smart Watch", "Fitness Tracker", 99.99, 15)
            };

            // === Product Menu ===
            while (true) {
                System.out.println("\n=== Product Catalog ===");
                for (int i = 0; i < products.length; i++) {
                    System.out.printf("%d. %s - $%.2f\n", i + 1, products[i].itemName, products[i].price);
                }
                System.out.println("0. Checkout");

                System.out.print("Select an item to add to cart (number): ");
                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (choice == 0) break;

                if (choice < 1 || choice > products.length) {
                    System.out.println("Invalid choice.");
                    continue;
                }

                ShoppingItem selectedItem = products[choice - 1];

                if (selectedItem instanceof ClothingItem) {
                    System.out.print("Enter clothing size (S/M/L/XL): ");
                    String size = sc.nextLine();
                    ((ClothingItem) selectedItem).setSize(size);
                }

                selectedItem.addToCart(customer);
            }

            // === Cart Summary ===
            double total = customer.getCart().getTotalPrice();
            if (total == 0) {
                System.out.println("No items in cart. Exiting.");
                return;
            }

            System.out.printf("\nTotal to Pay: $%.2f\n", total);

            // === Payment ===
            System.out.print("Enter payment method (Credit Card / PayPal): ");
            String paymentMethod = sc.nextLine();
            System.out.print("Enter amount to pay: $");
            double amount = sc.nextDouble();

            Payment payment = new Payment(paymentMethod, amount);
            if (!payment.validatePayment(total)) {
                System.out.println("Payment validation failed. Transaction canceled.");
                return;
            }

            // === Invoice ===
            System.out.println("\n=== Invoice Summary ===");
            for (ShoppingItem item : customer.getCart().cartItems) {
                item.generateInvoice(customer);
            }

            System.out.println("\nThank you for shopping with us!");
            sc.close();
        }
    }




