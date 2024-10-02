public class MobileDevice implements Observer {
    private String deviceName;

    public MobileDevice(String name) {
        this.deviceName = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("Device " + deviceName + ": Weather update! Temperature is now " + temperature + "°C");
    }
}
