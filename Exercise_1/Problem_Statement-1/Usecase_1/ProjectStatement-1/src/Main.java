import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherStation station = new WeatherStation();

        // Create default observers
        MobileDevice phone = new MobileDevice("Phone");
        DesktopApp desktop = new DesktopApp("Weather App");

        // Attach default observers
        station.attach(phone);
        station.attach(desktop);

        boolean exit = false;

        try {
            while (!exit) {
                System.out.println("\n---- Weather Station Menu ----");
                System.out.println("1. Set Temperature");
                System.out.println("2. Attach Observer");
                System.out.println("3. Detach Observer");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter new temperature: ");
                        int temperature = scanner.nextInt();
                        station.setTemperature(temperature);
                        break;
                    case 2:
                        System.out.print("Enter observer type (Mobile/ Desktop): ");
                        String observerType = scanner.nextLine();
                        Observer newObserver = null;
                        if (observerType.equalsIgnoreCase("Mobile")) {
                            System.out.print("Enter mobile device name: ");
                            String deviceName = scanner.nextLine();
                            newObserver = new MobileDevice(deviceName);
                        } else if (observerType.equalsIgnoreCase("Desktop")) {
                            System.out.print("Enter desktop app name: ");
                            String appName = scanner.nextLine();
                            newObserver = new DesktopApp(appName);
                        }
                        if (newObserver != null) {
                            station.attach(newObserver);
                            System.out.println("Observer attached.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter observer type to detach (Mobile/ Desktop): ");
                        observerType = scanner.nextLine();
                        System.out.print("Enter observer name: ");
                        String name = scanner.nextLine();
                        Observer observerToRemove = null;

                        if (observerType.equalsIgnoreCase("Mobile")) {
                            observerToRemove = new MobileDevice(name);
                        } else if (observerType.equalsIgnoreCase("Desktop")) {
                            observerToRemove = new DesktopApp(name);
                        }

                        if (observerToRemove != null) {
                            station.detach(observerToRemove);
                            System.out.println("Observer detached.");
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
