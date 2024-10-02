import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coffee coffee = new BasicCoffee();

        try {
            System.out.println("You have ordered: " + coffee.description());
            System.out.println("Cost: $" + coffee.cost());

            // Ask user if they want to add milk
            System.out.print("Do you want to add Milk? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                coffee = new MilkDecorator(coffee);
            }

            // Ask user if they want to add sugar
            System.out.print("Do you want to add Sugar? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                coffee = new SugarDecorator(coffee);
            }

            // Display final order
            System.out.println("Final Order: " + coffee.description());
            System.out.println("Total Cost: $" + coffee.cost());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
