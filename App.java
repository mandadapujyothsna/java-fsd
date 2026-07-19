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

    // Parent Method
    public double calculateDiscount() {
        return totalAmount * 0.05; // 5% discount
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Amount: " + totalAmount);
        System.out.println("Date: " + orderDate);
    }
}

// Child Class 1
class PremiumOrder extends Order {
    private String membershipTier;

    public PremiumOrder(String orderId, double totalAmount, String membershipTier) {
        super(orderId, totalAmount);
        this.membershipTier = membershipTier;
    }

    @Override
    public double calculateDiscount() {
        return super.calculateDiscount() + (totalAmount * 0.10); // Extra 10%
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Membership: " + membershipTier);
    }
}

// Child Class 2
class RegularOrder extends Order {
    private String deliveryType;

    public RegularOrder(String orderId, double totalAmount, String deliveryType) {
        super(orderId, totalAmount);
        this.deliveryType = deliveryType;
    }

    @Override
    public double calculateDiscount() {
        return super.calculateDiscount(); // Only 5%
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Delivery Type: " + deliveryType);
    }
}

// Main Class
public class App {
    public static void main(String[] args) {

        PremiumOrder p = new PremiumOrder("ORD101", 5000, "Gold");
        p.displayOrder();
        System.out.println("Premium Discount: " + p.calculateDiscount());

        System.out.println();

        RegularOrder r = new RegularOrder("ORD102", 3000, "Standard");
        r.displayOrder();
        System.out.println("Regular Discount: " + r.calculateDiscount());
    }
}