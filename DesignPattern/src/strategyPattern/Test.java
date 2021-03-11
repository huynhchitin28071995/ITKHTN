package strategyPattern;

public class Test {
public static void main(String[] args) {
	MallardDuck md = new MallardDuck();
	md.performFly();
	md.performQuack();
	md.swim();
	md.setFlyBehavior(new FlyNoWay());
	md.performFly();
	md.setFlyBehavior(new FlyBehavior() {
		
		@Override
		public void fly() {
			System.out.println("Anonymous class.");
		}
	});
	md.performFly();
}
}
