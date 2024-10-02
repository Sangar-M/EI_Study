public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.50; // Adding cost for milk
    }

    @Override
    public String description() {
        return decoratedCoffee.description() + ", Milk";
    }
}
