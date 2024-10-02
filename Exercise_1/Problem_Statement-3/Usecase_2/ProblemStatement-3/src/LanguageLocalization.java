import java.util.Locale;
import java.util.Scanner;

public class LanguageLocalization {
    public static void main(String[] args) {
        LanguageContext context = new LanguageContext();
        Scanner scanner = new Scanner(System.in);

        // Get user input for language preference
        System.out.print("Enter your preferred language (en for English, es for Spanish, fr for French): ");
        String userLanguage = scanner.nextLine().toLowerCase(); // Read input and convert to lowercase

        // Set localization strategy based on user preference
        switch (userLanguage) {
            case "es":
                context.setLocalizationStrategy(new SpanishLocalization());
                break;
            case "fr":
                context.setLocalizationStrategy(new FrenchLocalization());
                break;
            case "en":
            default:
                context.setLocalizationStrategy(new EnglishLocalization());
                break;
        }

        // Print greeting message
        try {
            System.out.println(context.greetUser());
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner resource
        }
    }
}