// Interface 1: Payment Contract
interface Payable {
    void processPayment(double amount);
    String getPaymentStatus();
    void refundPayment(double amount);
}

// Interface 2: Taxable Contract
interface Taxable {
    double calculateTax();
    void generateTaxInvoice();
}

// Interface 3: Logger Contract
interface Loggable {
    void logActivity(String action);
}

// A class can implement multiple interfaces
class CreditCardPayment implements Payable, Taxable, Loggable {

    private String cardNumber;
    private String status = "PENDING";
    private double amount;
    private double tax;

    // Constructor
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Implement Payable
    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        status = "SUCCESS";
        System.out.println("Payment of ₹" + amount + " processed using Credit Card.");
    }

    @Override
    public String getPaymentStatus() {
        return status;
    }

    @Override
    public void refundPayment(double amount) {
        status = "REFUNDED";
        System.out.println("Refund of ₹" + amount + " completed.");
    }

    // Implement Taxable
    @Override
    public double calculateTax() {
        tax = amount * 0.18; // 18% GST
        return tax;
    }

    @Override
    public void generateTaxInvoice() {
        System.out.println("\n------ Tax Invoice ------");
        System.out.println("Card Number : " + cardNumber);
        System.out.println("Amount      : ₹" + amount);
        System.out.println("GST (18%)   : ₹" + tax);
        System.out.println("Total       : ₹" + (amount + tax));
    }

    // Implement Loggable
    @Override
    public void logActivity(String action) {
        System.out.println("LOG: " + action);
    }
}

// Main class
public class New {
    public static void main(String[] args) {

        CreditCardPayment payment =
                new CreditCardPayment("1234-5678-9012-3456");

        payment.processPayment(1000);

        System.out.println("Payment Status: " + payment.getPaymentStatus());

        System.out.println("Tax: ₹" + payment.calculateTax());

        payment.generateTaxInvoice();

        payment.logActivity("Credit Card Payment Completed");

        payment.refundPayment(1000);

        System.out.println("Updated Status: " + payment.getPaymentStatus());
    }
}