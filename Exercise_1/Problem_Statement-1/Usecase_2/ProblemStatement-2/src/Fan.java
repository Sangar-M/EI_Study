// Fan.java
public class Fan {
    private String location;

    public Fan(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " fan is ON");
    }

    public void off() {
        System.out.println(location + " fan is OFF");
    }
}
