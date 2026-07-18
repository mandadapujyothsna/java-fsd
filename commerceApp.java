import java.util.Date;

// Parent Class
class Order {
    protected String orderId;
    protected String orderDate;
    protected double totalAmount;

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderDate = new Date().toString();
        System.out.println("Order Created: " + orderId);
    }

    // Parent method
    public double calculateDiscount() {
        return totalAmount * 0.05; // 5% discount
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Amount: " + totalAmount);
        System.out.println("Date: " + orderDate);
    }
}

// Child Class
class PremiumOrder extends Order {
    protected String membershipTier;

    public PremiumOrder(String orderId, double totalAmount, String membershipTier) {
        super(orderId, totalAmount);
        this.membershipTier = membershipTier;
        System.out.println("Premium Membership: " + membershipTier);
    }

    @Override
    public double calculateDiscount() {
        double baseDiscount = super.calculateDiscount();
        return baseDiscount + (totalAmount * 0.10); // Extra 10%
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Membership: " + membershipTier);
    }
}

// Grandchild Class
class VIPOrder extends PremiumOrder {
    private double cashback;

    public VIPOrder(String orderId, double totalAmount, String membershipTier) {
        super(orderId, totalAmount, membershipTier);
        this.cashback = totalAmount * 0.15;
        System.out.println("VIP Order Created");
    }

    @Override
    public double calculateDiscount() {
        double premiumDiscount = super.calculateDiscount();
        return premiumDiscount + (totalAmount * 0.05); // Extra 5%
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Cashback: " + cashback);
    }
}

// Main Class
public class commerceApp {
    public static void main(String[] args) {

        VIPOrder order = new VIPOrder("ORD123", 5000, "Gold");

        order.displayOrder();

        System.out.println("Total Discount: " + order.calculateDiscount());
    }
}