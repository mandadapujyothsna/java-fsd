interface Orderable {
    void placeOrder(String item, double price);
    String getOrderStatus();
    void cancelOrder();
}

interface Billable {
    double calculateGST();
    void generateBill();
}

interface Trackable {
    void trackOrder(String status);
}

class FoodDelivery implements Orderable, Billable, Trackable {

    private String item;
    private double price;
    private double gst;
    private String orderStatus = "PENDING";

    @Override
    public void placeOrder(String item, double price) {
        this.item = item;
        this.price = price;
        orderStatus = "CONFIRMED";
        System.out.println("Order Placed: " + item);
    }

    @Override
    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public void cancelOrder() {
        orderStatus = "CANCELLED";
        System.out.println("Order Cancelled.");
    }

    @Override
    public double calculateGST() {
        gst = price * 0.05;   // 5% GST
        return gst;
    }

    @Override
    public void generateBill() {
        System.out.println("\n----- BILL -----");
        System.out.println("Food Item : " + item);
        System.out.println("Price     : ₹" + price);
        System.out.println("GST (5%)  : ₹" + gst);
        System.out.println("Total     : ₹" + (price + gst));
    }

    @Override
    public void trackOrder(String status) {
        System.out.println("Order Status: " + status);
    }
}

public class FoodDeliveryDemo {

    public static void main(String[] args) {

        FoodDelivery order = new FoodDelivery();

        order.placeOrder("Pizza", 500);

        System.out.println("Current Status: " + order.getOrderStatus());

        order.calculateGST();
        order.generateBill();

        order.trackOrder("Out for Delivery");

        order.cancelOrder();

        System.out.println("Current Status: " + order.getOrderStatus());
    }
}