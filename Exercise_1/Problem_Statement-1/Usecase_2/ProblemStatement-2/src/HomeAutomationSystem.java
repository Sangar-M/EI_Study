// HomeAutomationSystem.java
import java.util.Scanner;

public class HomeAutomationSystem {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Fan bedroomFan = new Fan("Bedroom");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        FanOnCommand bedroomFanOn = new FanOnCommand(bedroomFan);
        FanOffCommand bedroomFanOff = new FanOffCommand(bedroomFan);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, bedroomFanOn, bedroomFanOff);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Turn ON Living Room Light");
            System.out.println("2. Turn OFF Living Room Light");
            System.out.println("3. Turn ON Bedroom Fan");
            System.out.println("4. Turn OFF Bedroom Fan");
            System.out.println("5. Undo Last Command");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remoteControl.onButtonPressed(0);
                    break;
                case 2:
                    remoteControl.offButtonPressed(0);
                    break;
                case 3:
                    remoteControl.onButtonPressed(1);
                    break;
                case 4:
                    remoteControl.offButtonPressed(1);
                    break;
                case 5:
                    remoteControl.undoLastCommand();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
