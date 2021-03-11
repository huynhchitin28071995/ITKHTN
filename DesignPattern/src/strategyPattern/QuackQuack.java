package strategyPattern;

public class QuackQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Quack quack!");
	}

}
