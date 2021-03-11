package strategyPattern;

public class MallardDuck extends Ducks {
	public MallardDuck() {
		this.setFlyBehavior(new FlyWithWings());
		this.setQuackBehavior(new QuackQuack());
	}

	@Override
	public void display() {
		System.out.println("This is a marllard duck!");
	}
	
	
}
