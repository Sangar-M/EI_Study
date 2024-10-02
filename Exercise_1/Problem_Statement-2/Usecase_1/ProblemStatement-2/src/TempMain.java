import java.util.Scanner;

public class TempMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter temperature in Celsius: ");
            double temperatureInCelsius = scanner.nextDouble();

            // Create a TemperatureSensor object
            TemperatureSensor sensor = new TemperatureSensor(temperatureInCelsius);
            // Create an adapter
            CelsiusToFahrenheitAdapter adapter = new CelsiusToFahrenheitAdapter(sensor);
            // Display temperature in Fahrenheit
            adapter.displayTemperature(sensor.getTemperatureInCelsius());
        } catch (Exception e) {
            System.err.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
