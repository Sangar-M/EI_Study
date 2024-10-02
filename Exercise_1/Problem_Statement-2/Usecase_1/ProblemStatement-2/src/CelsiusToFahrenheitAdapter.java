public class CelsiusToFahrenheitAdapter implements TemperatureDisplay {
    private TemperatureSensor sensor;

    public CelsiusToFahrenheitAdapter(TemperatureSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void displayTemperature(double temperatureInFahrenheit) {
        try {
            // Convert Celsius to Fahrenheit
            double temperatureInFahrenheitConverted = (sensor.getTemperatureInCelsius() * 9/5) + 32;
            System.out.println("Temperature in Fahrenheit: " + temperatureInFahrenheitConverted);
        } catch (Exception e) {
            System.err.println("Error converting temperature: " + e.getMessage());
        }
    }
}
