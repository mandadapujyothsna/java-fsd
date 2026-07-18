import java.util.Date;
class Order {
    protected String orderId;
    protected String orderDate;
    protected double totalAmount;

    // Parent parameterized constructor
    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderDate = new Date().toString();
        System.out.println("Order Created: " + orderId);
    }

    // Parent method
    public double calculateDiscount() {
        // Base discount: 5% for all orders
        return totalAmount * 0.05;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Amount: " + totalAmount);
        System.out.println("Date: " + orderDate);
    }
}

class PremiumOrder extends Order {
    private String membershipTier;
    private double cashback;

    // Using super() to call parent constructor
    public PremiumOrder(String orderId, double totalAmount, String member) {
        super(orderId, totalAmount);
        this.membershipTier = member;
        this.cashback = totalAmount * 0.10;
        System.out.println("Premium Order with " + membershipTier + " Membership");
    }

    // Method Overriding
    @Override
    public double calculateDiscount() {
        // Get parent's discount (5%) and add premium discount (10%)
        double baseDiscount = super.calculateDiscount();
        double premiumDiscount = totalAmount * 0.10;
        double finalDiscount = baseDiscount + premiumDiscount;

        System.out.println("Premium Discount Applied: " + finalDiscount);
        return finalDiscount;
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Membership: " + membershipTier);
        System.out.println("Cashback: " + cashback);
    }
}

public class EcomerceApp {
    public static void main(String[] args) {
        PremiumOrder order = new PremiumOrder("ORD123", 5000, "Gold");
        order.displayOrder();
        System.out.println("Total Discount: " + order.calculateDiscount());
    }
}
