import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        String continueAdding;

        // Loop to add items to the shopping cart
        do {
            System.out.print("Enter the price of the item to add to the cart: ");
            int price = scanner.nextInt();
            try {
                cart.addItem(price);
                System.out.println("Item added to cart.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to add another item? (yes/no): ");
            continueAdding = scanner.next();
        } while (continueAdding.equalsIgnoreCase("yes"));

        // Choose a payment method based on cultural preference
        System.out.println("Choose a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int paymentChoice = scanner.nextInt();

        PaymentStrategy paymentMethod = null;
        switch (paymentChoice) {
            case 1:
                System.out.print("Enter your credit card number: ");
                String cardNumber = scanner.next();
                paymentMethod = new CreditCardPayment(cardNumber);
                break;
            case 2:
                System.out.print("Enter your PayPal email: ");
                String email = scanner.next();
                paymentMethod = new PayPalPayment(email);
                break;
            default:
                System.out.println("Invalid payment method selected.");
                return;
        }

        cart.setPaymentStrategy(paymentMethod);

        // Checkout process
        try {
            cart.checkout();
        } catch (IllegalStateException e) {
            System.out.println("Error during checkout: " + e.getMessage());
        }

        scanner.close();
    }
}
