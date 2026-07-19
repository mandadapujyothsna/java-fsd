// Custom Exception
class InvalidRechargeException extends Exception {

    public InvalidRechargeException(String message) {
        super(message);
    }
}

// Main Class
public class MobileRecharge {

    public static void main(String[] args) {

        int rechargeAmount = 5;

        try {
            if (rechargeAmount < 10) {
                throw new InvalidRechargeException("Recharge amount must be at least ₹10.");
            }

            System.out.println("Recharge Successful.");

        } catch (InvalidRechargeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Thank you for using our service.");
    }
}