public class BasicCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.00; // Cost of basic coffee
    }

    @Override
    public String description() {
        return "Basic Coffee";
    }
}
