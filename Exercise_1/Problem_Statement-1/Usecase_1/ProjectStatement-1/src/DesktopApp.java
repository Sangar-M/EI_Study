public class DesktopApp implements Observer {
    private String appName;

    public DesktopApp(String name) {
        this.appName = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("App " + appName + ": Weather update! Temperature is now " + temperature + "°C");
    }
}
