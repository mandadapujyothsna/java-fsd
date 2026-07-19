import java.util.Date;

// Interface 1
interface Payable {
    void processPayment(double amount);
    String getPaymentStatus();
    void refundPayment(double amount);
}

// Interface 2
interface Taxable {
    double calculateTax();
    void generateTaxInvoice();
}

// Interface 3
interface Loggable {
    void logActivity(String action);
}

// PayPal Payment Class
class PayPalPayment implements Payable, Taxable, Loggable {

    private String email;
    private String status = "PENDING";
    private double amount;
    private double tax;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        System.out.println("Processing PayPal payment: $" + amount);
        status = "SUCCESS";
        logActivity("Payment processed: $" + amount);
    }

    @Override
    public String getPaymentStatus() {
        return status;
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding PayPal payment: $" + amount);
        status = "REFUNDED";
        logActivity("Refund processed: $" + amount);
    }

    @Override
    public double calculateTax() {
        tax = amount * 0.10;
        return tax;
    }

    @Override
    public void generateTaxInvoice() {
        System.out.println("\n----- Tax Invoice -----");
        System.out.println("Transaction : PayPal");
        System.out.println("Email       : " + email);
        System.out.println("Amount      : $" + amount);
        System.out.println("Tax (10%)   : $" + tax);
        System.out.println("Total       : $" + (amount + tax));
    }

    @Override
    public void logActivity(String action) {
        System.out.println("[LOG] PayPal: " + action + " at " + new Date());
    }
}

// UPI Payment Class
class UPIPayment implements Payable, Taxable, Loggable {

    private String upiId;
    private String status = "PENDING";
    private double amount;
    private double tax;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        System.out.println("Processing UPI payment: $" + amount);
        status = "SUCCESS";
        logActivity("Payment processed: $" + amount);
    }

    @Override
    public String getPaymentStatus() {
        return status;
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding UPI payment: $" + amount);
        status = "REFUNDED";
        logActivity("Refund processed: $" + amount);
    }

    @Override
    public double calculateTax() {
        tax = amount * 0.05;
        return tax;
    }

    @Override
    public void generateTaxInvoice() {
        System.out.println("\n----- Tax Invoice -----");
        System.out.println("Transaction : UPI");
        System.out.println("UPI ID      : " + upiId);
        System.out.println("Amount      : $" + amount);
        System.out.println("Tax (5%)    : $" + tax);
        System.out.println("Total       : $" + (amount + tax));
    }

    @Override
    public void logActivity(String action) {
        System.out.println("[LOG] UPI: " + action + " at " + new Date());
    }
}

// Main Class
public class PaymentDemo {

    public static void main(String[] args) {

        PayPalPayment paypal = new PayPalPayment("bhavana@gmail.com");
        paypal.processPayment(1000);
        System.out.println("Status: " + paypal.getPaymentStatus());
        paypal.calculateTax();
        paypal.generateTaxInvoice();

        System.out.println();

        UPIPayment upi = new UPIPayment("bhavana@upi");
        upi.processPayment(2000);
        System.out.println("Status: " + upi.getPaymentStatus());
        upi.calculateTax();
        upi.generateTaxInvoice();

        System.out.println();

        upi.refundPayment(2000);
        System.out.println("Status after Refund: " + upi.getPaymentStatus());
    }
}