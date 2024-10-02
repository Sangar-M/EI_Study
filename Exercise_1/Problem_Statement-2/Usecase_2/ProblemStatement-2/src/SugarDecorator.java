public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.20; // Adding cost for sugar
    }

    @Override
    public String description() {
        return decoratedCoffee.description() + ", Sugar";
    }
}
