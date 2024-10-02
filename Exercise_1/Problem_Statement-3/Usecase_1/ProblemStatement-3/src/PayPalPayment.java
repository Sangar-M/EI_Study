// PayPalPayment.java
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        // Simulate PayPal payment processing
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}
