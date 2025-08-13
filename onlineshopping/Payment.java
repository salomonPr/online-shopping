package onlineshopping;

import java.util.Date;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amountPaid;
    private Date transactionDate;

    public Payment(String paymentMethod, double amountPaid) {
        this.paymentId = "PAY-" + System.currentTimeMillis();
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = new Date();
    }

    public boolean validatePayment(double expectedAmount) {
        return amountPaid == expectedAmount && (paymentMethod.equalsIgnoreCase("Credit Card") || paymentMethod.equalsIgnoreCase("PayPal"));
    }
}

